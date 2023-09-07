package com.example.gsmsender.service.impl;

import com.example.gsmsender.dto.LogiGsm;
import com.example.gsmsender.enums.TYPES;
import com.example.gsmsender.enums.TypesUtility;
import com.example.gsmsender.service.GsmSenderService;
import org.springframework.stereotype.Service;

@Service(TypesUtility.LOGI_CODE)
public class LogiGsmService implements GsmSenderService<LogiGsm> {
    @Override
    public void send(LogiGsm request) {
        System.out.println("LogiGsmService.send");
        System.out.println(request.getMessage());
        System.out.println(request.getTo());
        System.out.println(request.getCc());
        System.out.println(request.getSubject());
    }
}
