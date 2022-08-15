package com.softuni.musicapp.service;

import com.softuni.musicapp.models.service.LogServiceModel;

import java.util.List;

public interface LogService {
    void createLog(String action, Long albumId);

    List<LogServiceModel> findAllLogs();
}
