package com.zw.domain;

import java.util.Date;

public class Jobscale {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jobscaletable.jid
     *
     * @mbggenerated Sun Nov 06 20:27:54 CST 2022
     */
    private String jid;

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    private Date createtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jobscaletable.headofdepartment
     *
     * @mbggenerated Sun Nov 06 20:27:54 CST 2022
     */
    private Integer headofdepartment;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jobscaletable.director
     *
     * @mbggenerated Sun Nov 06 20:27:54 CST 2022
     */
    private Integer director;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jobscaletable.leader
     *
     * @mbggenerated Sun Nov 06 20:27:54 CST 2022
     */
    private Integer leader;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jobscaletable.employee
     *
     * @mbggenerated Sun Nov 06 20:27:54 CST 2022
     */
    private Integer employee;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jobscaletable.jid
     *
     * @return the value of jobscaletable.jid
     *
     * @mbggenerated Sun Nov 06 20:27:54 CST 2022
     */
    public String getJid() {
        return jid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jobscaletable.jid
     *
     * @param jid the value for jobscaletable.jid
     *
     * @mbggenerated Sun Nov 06 20:27:54 CST 2022
     */
    public void setJid(String jid) {
        this.jid = jid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jobscaletable.headofdepartment
     *
     * @return the value of jobscaletable.headofdepartment
     *
     * @mbggenerated Sun Nov 06 20:27:54 CST 2022
     */
    public Integer getHeadofdepartment() {
        return headofdepartment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jobscaletable.headofdepartment
     *
     * @param headofdepartment the value for jobscaletable.headofdepartment
     *
     * @mbggenerated Sun Nov 06 20:27:54 CST 2022
     */
    public void setHeadofdepartment(Integer headofdepartment) {
        this.headofdepartment = headofdepartment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jobscaletable.director
     *
     * @return the value of jobscaletable.director
     *
     * @mbggenerated Sun Nov 06 20:27:54 CST 2022
     */
    public Integer getDirector() {
        return director;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jobscaletable.director
     *
     * @param director the value for jobscaletable.director
     *
     * @mbggenerated Sun Nov 06 20:27:54 CST 2022
     */
    public void setDirector(Integer director) {
        this.director = director;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jobscaletable.leader
     *
     * @return the value of jobscaletable.leader
     *
     * @mbggenerated Sun Nov 06 20:27:54 CST 2022
     */
    public Integer getLeader() {
        return leader;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jobscaletable.leader
     *
     * @param leader the value for jobscaletable.leader
     *
     * @mbggenerated Sun Nov 06 20:27:54 CST 2022
     */
    public void setLeader(Integer leader) {
        this.leader = leader;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jobscaletable.employee
     *
     * @return the value of jobscaletable.employee
     *
     * @mbggenerated Sun Nov 06 20:27:54 CST 2022
     */
    public Integer getEmployee() {
        return employee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jobscaletable.employee
     *
     * @param employee the value for jobscaletable.employee
     *
     * @mbggenerated Sun Nov 06 20:27:54 CST 2022
     */
    public void setEmployee(Integer employee) {
        this.employee = employee;
    }
}