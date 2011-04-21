package com.alibaba.intl.bcds.goldroom.dao;

import java.util.List;

import com.alibaba.intl.bcds.goldroom.dataobject.LendingLog;

public interface LendingLogDao {

    List<LendingLog> listLendingLogByBookInfoId(int bookInfoId);

    int countLendingLogByBookInfoId(int bookInfoId);

    List<LendingLog> listLendingLogByLoginIds(List<String> loginIds, int page, int pageSize);

    int countLendingLogByLoginIds(List<String> loginIds);

    LendingLog save(LendingLog lendingLog);
}
