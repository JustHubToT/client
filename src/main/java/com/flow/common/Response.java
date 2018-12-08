package com.flow.common;

import java.io.Serializable;

public class Response<T> implements Serializable {

    private boolean isSuccess;

    private T result;

    private String errCode;

    private String errMsg;

    public Response(){ }

    public Response(T result, boolean isSuccess, String errCode, String errMsg){
        this.result = result;
        this.isSuccess = isSuccess;
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public Response(boolean isSuccess, String errCode, String errMsg){
        this.isSuccess = isSuccess;
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    @Override
    public String toString() {
        return "Response{" +
                "isSuccess=" + isSuccess +
                ", result=" + result +
                ", errCode='" + errCode + '\'' +
                ", errMsg='" + errMsg + '\'' +
                '}';
    }
}
