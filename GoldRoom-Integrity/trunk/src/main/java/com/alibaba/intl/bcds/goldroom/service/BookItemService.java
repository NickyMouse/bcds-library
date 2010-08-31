package com.alibaba.intl.bcds.goldroom.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.intl.bcds.goldroom.constaints.BookItemStateEnum;
import com.alibaba.intl.bcds.goldroom.dao.BookItemDao;
import com.alibaba.intl.bcds.goldroom.dao.ReservationDao;
import com.alibaba.intl.bcds.goldroom.dataobject.BookItem;
import com.alibaba.intl.bcds.goldroom.dataobject.Reservation;
import com.alibaba.intl.bcds.goldroom.result.BookItemResult;

@Transactional
public class BookItemService {

    @Autowired
    private BookItemDao    bookItemDao;

    @Autowired
    private ReservationDao reservationDAO;

    private static Logger  logger = Logger.getLogger(BookItemService.class);

    public void addBookItem(BookItem bookItem) {
        bookItem.setState(BookItemStateEnum.IDLE.getValue());

        bookItemDao.save(bookItem);
        
        //TODO update bookItem Owner's Score 

        logger.info("[Add new book item] bookItem.id:" + bookItem.getId());
    }

    public BookItemResult listBookItemsByLoginIdAndState(String loginId, String state, int page, int pagesize) {
        int totalCount = 0;
        List<BookItem> itemList = new ArrayList<BookItem>();
        if (StringUtils.isEmpty(state) || "all".equalsIgnoreCase(state)) {
            totalCount = bookItemDao.countBookItemsByLoginId(loginId);
            itemList = bookItemDao.listBookItemsByLoginId(loginId, page, pagesize);
        } else {
            totalCount = bookItemDao.countBookItemsByLoginIdAndState(loginId, state);
            itemList = bookItemDao.listBookItemsByLoginIdAndState(loginId, state, page, pagesize);
        }
        return new BookItemResult(itemList, totalCount);
    }

    public List<BookItem> listBookItemByBookInfoId(int bookInfoId) {
        return bookItemDao.listBookItemByBookInfoId(bookInfoId);
    }

    public boolean offShelves(int bookItemId, String currentUser) {
        BookItem bookItem = bookItemDao.findById(bookItemId);
        if (bookItem == null || currentUser == null) {
            return false;
        } else {
            // 确定该书是属于currentUser的，并且这本书不处于借出（lended）状态
            if (currentUser.equals(bookItem.getOwner().getLoginId())
                && !BookItemStateEnum.LENDED.equalsState(bookItem.getState())) {
                // 改变书籍状�?
                bookItem.setState(BookItemStateEnum.UNAVAILABLE.getValue());
                bookItemDao.updateBookItemState(bookItem);

                // 拒绝�?��预约
                reservationDAO.updateStateByBookItemId(bookItem.getId(), Reservation.STATE_REJECT);

                return true;
            } else {
                return false;
            }
        }
    }

    public boolean reputOnShelves(int bookItemId, String currentUser) {
        BookItem bookItem = bookItemDao.findById(bookItemId);
        if (bookItem == null || currentUser == null) {
            return false;
        } else {
            // 确保该书是属于currentUser的，并且书的状态是UNAVAILABLE
            if (currentUser.equals(bookItem.getOwner().getLoginId())
                && BookItemStateEnum.UNAVAILABLE.equalsState(bookItem.getState())) {
                bookItem.setState(BookItemStateEnum.IDLE.getValue());
                bookItemDao.updateBookItemState(bookItem);
                return true;
            } else {
                return false;
            }
        }
    }

    public BookItem getBookDetailByIdAndOwner(String owner, int bookItemId) {
        BookItem bookItem = bookItemDao.findById(bookItemId);
        if (bookItem != null && bookItem.getOwner().getLoginId().equals(owner)) {
            return bookItem;
        }
        return bookItem;
    }

    public boolean deleteBookItem(int id, String loginId) {
        BookItem bookItem = bookItemDao.findById(id);
        if (BookItemStateEnum.UNAVAILABLE.equalsState(bookItem.getState())
            && loginId.equals(bookItem.getOwner().getLoginId())) {
            bookItemDao.deleteById(id);
            return true;
        }
        return false;
    }

    public List<BookItem> listBookItemsByLoginIdAndStateAndBookInfoIds(String loginId, String state,
                                                                       List<Integer> bookInfoIds) {
        return bookItemDao.listBookItemsByLoginIdAndStateAndBookInfoIds(loginId, state, bookInfoIds);
    }

    public List<BookItem> listBookItemsByLoginIdsAndBookInfoId(List<String> loginIds, Integer bookInfoId) {
        return bookItemDao.listBookItemsByLoginIdsAndBookInfoId(loginIds, bookInfoId);

    }
}
