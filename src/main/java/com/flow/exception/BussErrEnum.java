package com.flow.exception;

public enum BussErrEnum {
    S_000("000", "成功"),
    E_001("001", "系统异常"),
    E_002("002", "查询数据为空"),
    E_003("003", "删除数据失败"),
    E_004("004", "修改数据失败"),
    E_005("005", "新增数据失败");

    private String errCode;
    private String errMsg;

    BussErrEnum(String errCode, String errMsg){
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public String getErrCode() {
        return errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }
}
