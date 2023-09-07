package com.example.gsmsender.enums;

import com.example.gsmsender.dto.LightGsm;
import com.example.gsmsender.dto.LogiGsm;
import com.example.gsmsender.dto.NetroGsm;

public enum TYPES {
    NETRO(TypesUtility.NETRO_CODE, NetroGsm.class),
    LIGHT(TypesUtility.LIGHT_CODE, LightGsm.class),
    LOGI(TypesUtility.LOGI_CODE, LogiGsm.class);

    public final String code;
    public final Class<?> clazz;

    TYPES(String code, Class<?> clazz) {
        this.code = code;
        this.clazz = clazz;
    }

    public String getCode() {
        return code;
    }

    public Class<?> getClazz() {
        return clazz;
    }
}
