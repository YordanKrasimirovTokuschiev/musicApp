package com.softuni.musicapp.service;

import com.softuni.musicapp.models.entities.UserEntity;
import com.softuni.musicapp.models.service.UserRegisterServiceModel;

public interface UserService {
    void seedUsers();
    void registerAndLoginUser(UserRegisterServiceModel serviceModel);
    boolean userNameExists(String username);

    UserEntity findByName(String username);
}
