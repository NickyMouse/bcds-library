package com.alibaba.intl.bcds.goldroom.dataobject;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "ADMIN_CONFIG")
@NamedQueries({
               @NamedQuery(name = "listConfigByType", query = "SELECT c FROM AdminConfig c WHERE type = :type ORDER BY gmtCreate DESC"),
               @NamedQuery(name = "updateConfigByType", query = "SELECT c FROM AdminConfig c WHERE type = :type ORDER BY gmtCreate DESC")

})
public class AdminConfig {

    @Id
    @GeneratedValue
    Integer        id;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "CONFIG")
    private String config;

    @Column(name = "GMT_CREATE")
    private Date   gmtCreate;

    @Column(name = "GMT_MODIFIED")
    private Date   gmtModified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

}
