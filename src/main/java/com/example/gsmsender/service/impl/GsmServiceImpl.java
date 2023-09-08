package com.example.gsmsender.service.impl;

import com.example.gsmsender.dto.GsmRequest;
import com.example.gsmsender.service.GsmSenderService;
import com.example.gsmsender.service.GsmService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

@Service
public class GsmServiceImpl implements GsmService {
    Logger logger = LoggerFactory.getLogger(GsmServiceImpl.class);

    private final Map<String, GsmSenderService<?>> gsmServices;
    private final ObjectMapper objectMapper;

    public GsmServiceImpl(Map<String, GsmSenderService<?>> gsmServices, ObjectMapper objectMapper) {
        this.gsmServices = gsmServices;
        this.objectMapper = objectMapper;
    }

    @Override
    public void send(GsmRequest gsmRequest) {
        Assert.notNull(gsmRequest, "gsmRequest can not be null");
        Assert.notNull(gsmRequest.getGsmRequestType(), "gsmRequestType can not be null");
        Assert.notNull(gsmRequest.getGsmRequestObj(), "gsmRequestObj can not be null");

        String typeCode = gsmRequest.getGsmRequestType().getCode();
        Class<?> targetClass = gsmRequest.getGsmRequestType().getClazz();
        GsmSenderService<?> gsmSenderService = gsmServices.get(typeCode);

        Object gsmRequestObject = objectMapper.convertValue(gsmRequest.getGsmRequestObj(), targetClass);


        // Reflection
        try {
            Method method = gsmSenderService.getClass().getMethod("send", targetClass);
            method.invoke(gsmSenderService, targetClass.cast(gsmRequestObject));
            logger.debug("GsmServiceImpl.send() is invoked");
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
