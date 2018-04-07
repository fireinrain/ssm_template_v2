package com.sunrise.enums;

public enum AppointmentStateEnum {
    SUCCESS(1,"预约成功"),
    NO_NUMBER(0,"库存不足"),
    RE_APPOINT(-1,"重复预约"),
    SYSTEM_ERROR(-2,"系统异常");

    public Integer code;
    public String message;


    AppointmentStateEnum(Integer i,String message){
        this.code = i;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 根据一个状态码 返回一个状态枚举对象
     * @param index
     * @return
     */
    public static AppointmentStateEnum stateOf(int index){
        for (AppointmentStateEnum e:AppointmentStateEnum.values()
             ) {
            if (e.code==index){
                return e;
            }
        }
        return null;
    }
}
