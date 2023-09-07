package com.example.gsmsender.service;

import com.example.gsmsender.dto.GsmRequest;

import java.io.IOException;

public interface GsmService {
    void send(GsmRequest request) throws IOException;
}

// Compare this snippet from src\main\java\com\example\gsmsender\service\impl\GsmServiceImpl.java: