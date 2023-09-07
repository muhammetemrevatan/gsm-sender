package com.example.gsmsender.service.impl;

import com.example.gsmsender.dto.NetroGsm;
import com.example.gsmsender.enums.TypesUtility;
import com.example.gsmsender.service.GsmSenderService;
import org.springframework.stereotype.Service;

@Service(TypesUtility.NETRO_CODE)
public class NetroGsmService implements GsmSenderService<NetroGsm> {
    @Override
    public void send(NetroGsm request) {
        System.out.println("NetroGsmService.send");
        System.out.println(request.getMessage());
        System.out.println(request.getTo());
        System.out.println(request.getSubject());
    }
}
