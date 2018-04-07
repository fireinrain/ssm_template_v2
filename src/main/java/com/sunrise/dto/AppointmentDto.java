package com.sunrise.dto;

import com.sunrise.entity.Appointment;
import com.sunrise.enums.AppointmentStateEnum;

/**
 * 返回给前端的对象
 */
public class AppointmentDto {
    //图书id
    private Long bookId;
    //预约状态
    private Integer code;
    //预约信息
    private String stateInfo;
    //预约成功返回的appointment对象
    private Appointment appointment;

    /**
     * 预约失败的constructor
     * @param bookId
     * @param appointmentStateEnum
     */
    public AppointmentDto(Long bookId, AppointmentStateEnum appointmentStateEnum){
        this.bookId = bookId;
        this.code = appointmentStateEnum.getCode();
        this.stateInfo = appointmentStateEnum.getMessage();
    }

    /**
     * 预约成功的constructor
     * @param bookId
     * @param stateEnum
     * @param appointment
     */
    public AppointmentDto(Long bookId,AppointmentStateEnum stateEnum,Appointment appointment){
        this.bookId = bookId;
        this.code = stateEnum.getCode();
        this.stateInfo = stateEnum.getMessage();
        this.appointment = appointment;
    }


    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
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
        return "AppointmentDto{" +
                "bookId=" + bookId +
                ", code=" + code +
                ", stateInfo='" + stateInfo + '\'' +
                ", appointment=" + appointment +
                '}';
    }
}
