/**
 *
 */
package com.alibaba.intl.bcds.goldroom.dataobject;

import java.io.Serializable;

/**
 * 登录用户信息数据
 *
 * @author Harrison
 */
public class UserDTO implements Serializable {

    /**
	 *
	 */
    private static final long  serialVersionUID          = -8320248564515794757L;

    public static final String MEMBER_LOGGED_SESSION_KEY = "LOGGED_USER";          // 用户登录后的Session Key
    /**
     * apache 使用
     */
    public static final String SSL_CLIENT_S_DN_Email     = "SSL_CLIENT_S_DN_Email"; // CA 用户证书Key

    /**
     * nginx使用 <br/>
     * request中的格式为："/C=CN/ST=ZheJiang/L=HangZhou/O=Alibaba/OU=Corp/CN=gangyi.xiaogy/emailAddress=gangyi.xiaogy@alibaba
     * -inc.com" <br/>
     * 需要解析出对应的值
     */
    public static final String SSL_CLIENT_S_DN           = "SSL_CLIENT_S_DN";

    private String             userName;                                           // 用户名
    private Integer            id;                                                 // 用户ID
    private Integer            score;                                              // 积分
    private boolean            isBind;                                             // 是否绑定
    private String             loginId;                                            // 用户的loginID

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getLoginId() {
        return loginId;
    }
}
