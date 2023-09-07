package com.example.gsmsender.service.impl;

import com.example.gsmsender.dto.LightGsm;
import com.example.gsmsender.enums.TYPES;
import com.example.gsmsender.enums.TypesUtility;
import com.example.gsmsender.service.GsmSenderService;
import org.springframework.stereotype.Service;

@Service(TypesUtility.LIGHT_CODE)
public class LightGsmService implements GsmSenderService<LightGsm> {
    @Override
    public void send(LightGsm request) {
        System.out.println("LightGsmService.send");
        System.out.println(request.getMessage());
        System.out.println(request.getTo());
    }
}
