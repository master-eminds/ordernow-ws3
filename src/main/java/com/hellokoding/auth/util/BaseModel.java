package com.hellokoding.auth.util;


public class BaseModel {
    private String result;
    private String info;
    private String extendedInfo;

    public BaseModel() {
        this.result = "OK";
        this.info = "Request successful";
        this.extendedInfo = "";
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getExtendedInfo() {
        return extendedInfo;
    }

    public void setExtendedInfo(String extendedInfo) {
        this.extendedInfo = extendedInfo;
    }
}
