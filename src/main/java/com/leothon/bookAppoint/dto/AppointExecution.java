package com.leothon.bookAppoint.dto;


import com.leothon.bookAppoint.entity.Appointment;
import com.leothon.bookAppoint.enums.AppointStateEnum;

public class AppointExecution {
    private long bookId;

    private int state;

    private String stateInfo;

    private Appointment appointment;

    public AppointExecution(){

    }

    /**
     * 预约失败构造器
     * @param bookId
     * @param appointStateEnum
     */

    public AppointExecution(long bookId, AppointStateEnum appointStateEnum){
        this.bookId = bookId;
        this.state = appointStateEnum.getState();
        this.stateInfo = appointStateEnum.getStateInfo();
    }


    /**
     * 预约成功构造器
     * @param bookId
     * @param stateEnum
     * @param appointment
     */
    public AppointExecution(long bookId,AppointStateEnum stateEnum,Appointment appointment){
        this.bookId = bookId;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.appointment = appointment;
    }


    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    @Override
    public String toString() {
        return "预约结果显示:{" + "图书ID" + bookId + "预约状态代码" + state + "预约状态" + stateInfo + "预约信息" + appointment + "}";
    }
}

