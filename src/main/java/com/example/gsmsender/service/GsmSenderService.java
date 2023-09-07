package com.example.gsmsender.service;

public interface GsmSenderService<T> {
    void send(T request);
}
