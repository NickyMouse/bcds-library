package com.alibaba.intl.bcds.goldroom.mail.enumeration;

public enum ServiceType {
    /**
     * 1.用户申请帐号,审核通过邮件, to:帐号申请者
     */
    ACCOUNT_APPROVED("notify.account.approved", "accountApproved.vm", "黄金屋 [Gold Room] 系统邮件：您的帐号审批通过了。"),

    /**
     * 2.用户申请帐号,审核通过邮件, to:帐号申请者
     */
    ACCOUNT_TBD("notify.account.tbd", "accountTbd.vm", "黄金屋 [Gold Room] 系统邮件：您的帐号未能通过审批。"),

    /**
     * 3.有人预约的时候，邮件提醒, to:书籍拥有者
     */
    RESERVATION("notify.reservation", "reservation.vm", "黄金屋 [Gold Room] 系统邮件：您的书籍已被预约。"),

    /**
     * 4.预约被拒绝。to:书籍借阅者
     */
    REJECT_LEND_BOOK("notify.reject.lend.book", "rejectLendBook.vm", "黄金屋 [Gold Room] 系统邮件：你的书籍借阅被拒绝了。"),

    /**
     * 5.图书成功预约后,书主确认借书时,通知成功借阅者去拿书. to:书籍借阅者
     */
    GET_BOOK("notify.get.book", "getBook.vm", "黄金屋 [Gold Room] 系统邮件：你的书籍预约已被批准。"),

    /**
     * 6.有人还书，拥有者确认还书，邮件提醒。to:书籍借阅者
     */
    CONFIRM_RETURN_BOOK("notify.return.book", "confirmReturnBook.vm", "黄金屋 [Gold Room] 系统邮件：你的书籍已经成功归还。"),

    /**
     * 7.书籍离归还前还有n天的提醒。to:书籍借阅者
     */
    SHOULD_RETURN_BOOK("notify.should.return.book", "shouldReturnBook.vm", "黄金屋 [Gold Room] 系统邮件：您的书籍应该要归还了。"),
    /**
     * 8.忘记密码，重置密码邮件
     */
    FORGET_PASSWORD("forget.password", "forgetPassword.vm", "黄金屋 [Gold Room] 系统邮件：您的密码已经重置");

    private String serviceName;
    private String templateName;
    private String subject;

    /**
     * @param serviceName
     * @param templateName
     * @param subject
     */
    ServiceType(String serviceName, String templateName, String subject) {
        this.serviceName = serviceName;
        this.templateName = templateName;
        this.subject = subject;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getTemplateName() {
        return templateName;
    }

    public String getSubject() {
        return subject;
    }
}
