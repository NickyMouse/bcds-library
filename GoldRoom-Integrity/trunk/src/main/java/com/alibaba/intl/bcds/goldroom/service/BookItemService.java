package com.alibaba.intl.bcds.goldroom.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.intl.bcds.goldroom.constaints.BookItemStateEnum;
import com.alibaba.intl.bcds.goldroom.constaints.BookStoreState;
import com.alibaba.intl.bcds.goldroom.dao.BookInfoDao;
import com.alibaba.intl.bcds.goldroom.dao.BookItemDao;
import com.alibaba.intl.bcds.goldroom.dao.MemberDao;
import com.alibaba.intl.bcds.goldroom.dao.ReservationDao;
import com.alibaba.intl.bcds.goldroom.dataobject.BookInfo;
import com.alibaba.intl.bcds.goldroom.dataobject.BookItem;
import com.alibaba.intl.bcds.goldroom.dataobject.Member;
import com.alibaba.intl.bcds.goldroom.dataobject.Reservation;
import com.alibaba.intl.bcds.goldroom.remote.BookInfoFetcher;
import com.alibaba.intl.bcds.goldroom.result.BookItemResult;
import com.alibaba.intl.bcds.goldroom.util.WeiboHelper;

@Transactional
public class BookItemService {

    @Autowired
    private BookItemDao     bookItemDao;

    @Autowired
    private BookInfoDao     bookInfoDao;

    @Autowired
    private MemberDao       memberDao;

    @Autowired
    private ReservationDao  reservationDao;

    private static Logger   logger = Logger.getLogger(BookItemService.class);

    private BookInfoFetcher bookInfoFetcher;

    private WeiboHelper     weiboHelper;

    /**
     * 新增纸质书
     *
     * @param bookItem
     */
    public void addBookItem(BookItem bookItem) {

        bookItem.setState(BookItemStateEnum.IDLE.getValue());

        if (bookItem.getBookInfo() != null && bookItem.getBookInfo().getIsbn() != null) {
            String isbn = bookItem.getBookInfo().getIsbn();
            BookInfo bookInfo = bookInfoDao.findBookInfoByIsbn(isbn);
            if (bookInfo == null) {
                bookInfo = bookInfoFetcher.fetch(isbn);
                if (bookInfo == null) {
                    return;
                }
                bookInfoDao.save(bookInfo);
                weiboHelper.sendNewBookMessage(bookInfo);
            }

            BookStoreState newState = BookStoreState.getUpdatedStoreState(bookInfo.getStoreState(),
                                                                          BookStoreState.PAPER_BOOK);
            bookInfo.setStoreState(newState.getValue());
            bookInfoDao.updateById(bookInfo);
            bookItem.setBookInfo(bookInfo);
            bookItemDao.save(bookItem);

            try {
                Member m = memberDao.findByLoginId(bookItem.getOwner().getLoginId());
                m.setScore(m.getScore() == null || m.getScore() == 0 ? 100 : m.getScore() + 100);
                bookItem.setOwner(m);
                memberDao.updateMemberByLoginId(m);
            } catch (Exception e) {
                logger.error(e);
            }
        }

        logger.info("[Add new book item] bookItem.id:" + bookItem.getId());
    }

    /**
     * 新增电子书
     *
     * @param bookItem
     */
    public boolean addEbookItem(BookItem bookItem) {
        if (bookItem != null && bookItem.getBookInfo() != null && bookItem.getBookInfo().getIsbn() != null) {
            String isbn = bookItem.getBookInfo().getIsbn();
            BookInfo bookInfo = bookInfoDao.findBookInfoByIsbn(isbn);
            if (bookInfo == null) {
                bookInfo = bookInfoFetcher.fetch(isbn);
                if (bookInfo == null) {
                    return false;
                }
                bookInfoDao.save(bookInfo);
                weiboHelper.sendNewBookMessage(bookInfo);
            }

            if (BookStoreState.isEBookExist(bookInfo.getStoreState())) {
                return false;
            }
            BookStoreState newState = BookStoreState.getUpdatedStoreState(bookInfo.getStoreState(),
                                                                          BookStoreState.EBOOK);

            bookInfo.setEBookUrl(bookItem.getBookInfo().getEBookUrl());
            bookInfo.setStoreState(newState.getValue());
            bookInfoDao.updateById(bookInfo);

            bookItem.setState(BookItemStateEnum.EBOOK.getValue());
            bookItem.setBookInfo(bookInfo);
            bookItemDao.save(bookItem);
            logger.info("[Add new Ebook item] bookItem.id:" + bookItem.getId());

            try {
                Member m = memberDao.findByLoginId(bookItem.getOwner().getLoginId());
                m.setScore(m.getScore() == null || m.getScore() == 0 ? 100 : m.getScore() + 100);
                bookItem.setOwner(m);
                memberDao.updateMemberByLoginId(m);
            } catch (Exception e) {
                logger.error(e);
            }
            return true;
        } else {
            return false;
        }
    }

    public BookItemResult listBookItemsByLoginIdAndState(String loginId, String state, int page, int pagesize) {
        int totalCount = 0;
        List<BookItem> itemList;
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
                bookItem.setState(BookItemStateEnum.UNAVAILABLE.getValue());
                bookItemDao.updateBookItemState(bookItem);

                reservationDao.updateStateByBookItemId(bookItem.getId(), Reservation.STATE_REJECT);

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

    /**
     * 按时间排序取count条记录
     *
     * @param count取数据的数量
     * @return
     */
    public List<BookItem> getBookItemsByAddtime(int count) {
        return bookItemDao.getBookItemsByAddtime(count);
    }

    /**
     * @return the bookItemDao
     */
    public BookItemDao getBookItemDao() {
        return bookItemDao;
    }

    /**
     * @param bookItemDao the bookItemDao to set
     */
    public void setBookItemDao(BookItemDao bookItemDao) {
        this.bookItemDao = bookItemDao;
    }

    /**
     * @return the reservationDao
     */
    public ReservationDao getReservationDao() {
        return reservationDao;
    }

    /**
     * @param reservationDao the reservationDao to set
     */
    public void setReservationDao(ReservationDao reservationDao) {
        this.reservationDao = reservationDao;
    }

    public void setBookInfoDao(BookInfoDao bookInfoDao) {
        this.bookInfoDao = bookInfoDao;
    }

    public BookInfoDao getBookInfoDao() {
        return bookInfoDao;
    }

    public BookItem findById(Integer id) {
        return bookItemDao.findById(id);
    }

    public void setBookInfoFetcher(BookInfoFetcher bookInfoFetcher) {
        this.bookInfoFetcher = bookInfoFetcher;
    }

    public BookInfoFetcher getBookInfoFetcher() {
        return bookInfoFetcher;
    }

    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public MemberDao getMemberDao() {
        return memberDao;
    }

    public void setWeiboHelper(WeiboHelper weiboHelper) {
        this.weiboHelper = weiboHelper;
    }

    public WeiboHelper getWeiboHelper() {
        return weiboHelper;
    }

}
