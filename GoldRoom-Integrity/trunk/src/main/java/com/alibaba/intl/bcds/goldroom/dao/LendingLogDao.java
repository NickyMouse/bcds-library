package com.alibaba.intl.bcds.goldroom.dao;

import java.util.List;

import com.alibaba.intl.bcds.goldroom.dataobject.LendingLog;

public interface LendingLogDao {

    List<LendingLog> listLendingLogByBookInfoId(int bookInfoId);

    int countLendingLogByBookInfoId(int bookInfoId);

    List<LendingLog> listLendingLogByLoginId(String loginId, int page, int pageSize);

    int countLendingLogByLoginId(String loginId);

    LendingLog save(LendingLog lendingLog);
}
