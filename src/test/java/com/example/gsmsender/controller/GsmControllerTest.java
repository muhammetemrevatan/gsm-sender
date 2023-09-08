package com.example.gsmsender.controller;


import com.example.gsmsender.dto.GsmRequest;
import com.example.gsmsender.dto.NetroGsm;
import com.example.gsmsender.enums.TYPES;
import com.example.gsmsender.service.GsmService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GsmController.class)
class GsmControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GsmService gsmService;

    @Test
    void givenValidRequest_whenSendIsCalled_thenResponseShouldBeSuccess() throws Exception {
        NetroGsm netroGsm = new NetroGsm();
        netroGsm.setTo("123456789");

        GsmRequest gsmRequest = new GsmRequest();
        gsmRequest.setGsmRequestType(TYPES.NETRO);
        gsmRequest.setGsmRequestObj(netroGsm);

        String gsmRequestJson = new ObjectMapper().writeValueAsString(gsmRequest);

        doNothing().when(gsmService).send(gsmRequest);

        mockMvc.perform(post("/api/gsm/send")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gsmRequestJson))
                .andExpect(status().isOk());
    }

}