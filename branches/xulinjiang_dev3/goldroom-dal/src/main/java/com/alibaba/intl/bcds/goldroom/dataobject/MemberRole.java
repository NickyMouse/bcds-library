package com.alibaba.intl.bcds.goldroom.dataobject;

public class MemberRole {
    private Integer id;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column member_role.member_id
     *
     * @ibatorgenerated Tue Nov 03 10:57:59 CST 2009
     */
    private Integer memberId;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column member_role.role_id
     *
     * @ibatorgenerated Tue Nov 03 10:57:59 CST 2009
     */
    private Integer roleId;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column member_role.ID
     *
     * @return the value of member_role.ID
     *
     * @ibatorgenerated Tue Nov 03 10:57:59 CST 2009
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column member_role.ID
     *
     * @param id the value for member_role.ID
     *
     * @ibatorgenerated Tue Nov 03 10:57:59 CST 2009
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column member_role.member_id
     *
     * @return the value of member_role.member_id
     *
     * @ibatorgenerated Tue Nov 03 10:57:59 CST 2009
     */
    public Integer getMemberId() {
        return memberId;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column member_role.member_id
     *
     * @param memberId the value for member_role.member_id
     *
     * @ibatorgenerated Tue Nov 03 10:57:59 CST 2009
     */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column member_role.role_id
     *
     * @return the value of member_role.role_id
     *
     * @ibatorgenerated Tue Nov 03 10:57:59 CST 2009
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column member_role.role_id
     *
     * @param roleId the value for member_role.role_id
     *
     * @ibatorgenerated Tue Nov 03 10:57:59 CST 2009
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}