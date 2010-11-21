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
@Table(name = "TRACELOG")
public class Tracelog {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int    id;

    @Column(name = "GMT_CREATE")
    private Date   gmtCreate;

    @Column(name = "REFERER")
    private String referer;

    @Column(name = "PATH")
    private String path;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "IP")
    private String ip;

    @Column(name = "PARAM")
    private String param;

    @Column(name = "PARAM1")
    private String param1;

    @Column(name = "PARAM2")
    private String param2;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getReferer() {
        return referer;
    }

    public void setReferer(String referer) {
        this.referer = referer;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getParam1() {
        return param1;
    }

    public void setParam1(String param1) {
        this.param1 = param1;
    }

    public String getParam2() {
        return param2;
    }

    public void setParam2(String param2) {
        this.param2 = param2;
    }

}
