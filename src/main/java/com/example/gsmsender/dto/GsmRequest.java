package com.example.gsmsender.dto;

import com.example.gsmsender.enums.TYPES;

public class GsmRequest {
    private TYPES gsmRequestType;
    private Object gsmRequestObj;

    public TYPES getGsmRequestType() {
        return gsmRequestType;
    }

    public void setGsmRequestType(TYPES gsmRequestType) {
        this.gsmRequestType = gsmRequestType;
    }

    public Object getGsmRequestObj() {
        return gsmRequestObj;
    }

    public void setGsmRequestObj(Object gsmRequestObj) {
        this.gsmRequestObj = gsmRequestObj;
    }
}
