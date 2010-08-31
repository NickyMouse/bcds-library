package com.alibaba.intl.bcds.goldroom.mail.checker;

import com.alibaba.intl.bcds.goldroom.mail.dataobject.EmailInfo;

public interface EmailInfoChecker {

    boolean isOk(EmailInfo emailInfo);
}
