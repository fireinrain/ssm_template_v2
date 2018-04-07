package com.sunrise.dto;

public class ResultBean<T> {

    private boolean success;

    private T data;

    private String error;

    public ResultBean() {
    }

    /**
     * 成功时构造
     * @param success
     * @param data
     */
    public ResultBean(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    /**
     * 失败是构造
     * @param success
     * @param error
     */
    public ResultBean(boolean success,String error) {
        this.error = error;
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
