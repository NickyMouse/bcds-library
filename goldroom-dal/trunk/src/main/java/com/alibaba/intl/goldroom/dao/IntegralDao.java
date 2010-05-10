package com.alibaba.intl.goldroom.dao;

import java.util.List;

import com.alibaba.intl.goldroom.dataobject.Integral;

public interface IntegralDao {

    public List<Integral> listAllIntegral(int page, int pageSize);

    public Integral save(Integral integral);

    public boolean updateByLoginId(Integral integral);

    public Integral findByLoginId(String loginId);

}
