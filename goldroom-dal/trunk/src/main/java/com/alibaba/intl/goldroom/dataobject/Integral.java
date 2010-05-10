package com.alibaba.intl.goldroom.dataobject;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author Larry Su
 */
@Entity
@Table(name = "INTEGRAL")
@NamedQueries({ @NamedQuery(name = "listAllIntegral", query = "SELECT i FROM Integral i ORDER BY value DESC")

})
public class Integral {

    @GeneratedValue
    @Column(name = "ID")
    private Integer id;

    // 创建记录时间
    @Column(name = "GMT_CREATE")
    private Date    gmtCreate;

    // 修改记录时间
    @Column(name = "GMT_MODIFIED")
    private Date    gmtModified;

    // 用户登录ID
    @Id
    @Column(name = "LOGIN_ID")
    private String  loginId;

    // 积分值
    @Column(name = "VALUE")
    private long    value;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getGmtCreate() {
        return this.gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return this.gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getLoginId() {
        return this.loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public long getValue() {
        return this.value;
    }

    public void setValue(long value) {
        this.value = value;
    }

}
