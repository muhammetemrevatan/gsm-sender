package com.example.gsmsender.controller;

import com.example.gsmsender.dto.GsmRequest;
import com.example.gsmsender.service.GsmService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class GsmController {
    private final GsmService gsmService;

    public GsmController(GsmService gsmService) {
        this.gsmService = gsmService;
    }

    @PostMapping("/send")
    public void send(@RequestBody GsmRequest request) throws IOException {
        gsmService.send(request);
    }
}
