package com.alibaba.intl.goldroom.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.alibaba.intl.goldroom.dao.BookItemLogDao;
import com.alibaba.intl.goldroom.dataobject.BookItemLog;

public class BookItemLogDaoImpl implements BookItemLogDao {

    @PersistenceContext(unitName = "goldroomPU")
    private EntityManager em;

    public List<BookItemLog> listAll() {
        // TODO Auto-generated method stub
        return null;
    }

    public BookItemLog save(BookItemLog bookItemLogDO) {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean updateById(BookItemLog bookItemLogDO) {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean deleteById(Integer id) {
        // TODO Auto-generated method stub
        return false;
    }

    public BookItemLog findById(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

  
}
