package com.softuni.musicapp.service.implementation;

import com.softuni.musicapp.models.entities.AlbumEntity;
import com.softuni.musicapp.models.entities.LogEntity;
import com.softuni.musicapp.models.entities.UserEntity;
import com.softuni.musicapp.repository.LogRepository;
import com.softuni.musicapp.service.AlbumService;
import com.softuni.musicapp.service.LogService;
import com.softuni.musicapp.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LogServiceImpl implements LogService {

    private final LogRepository logRepository;
    private final AlbumService albumService;
    private final UserService userService;

    public LogServiceImpl(LogRepository logRepository, AlbumService albumService, UserService userService) {
        this.logRepository = logRepository;
        this.albumService = albumService;
        this.userService = userService;
    }

    @Override
    public void createLog(String action, Long albumId) {

        AlbumEntity albumEntity = albumService
                .findEntityById(albumId);

        Authentication authentication = SecurityContextHolder
                .getContext()
                .getAuthentication();

        String username = authentication.getName();
        UserEntity userEntity = userService.findByName(username);

        LogEntity logEntity = new LogEntity()
                .setAlbumEntity(albumEntity)
                .setUserEntity(userEntity)
                .setAction(action)
                .setLocalDateTime(LocalDateTime.now());

        logRepository.save(logEntity);
    }
}
