package com.softuni.musicapp.service;

import com.softuni.musicapp.models.entities.AlbumEntity;
import com.softuni.musicapp.models.service.AlbumServiceModel;
import com.softuni.musicapp.models.view.AlbumViewModel;

public interface AlbumService {

    void createAlbum(AlbumServiceModel serviceModel);

    AlbumViewModel findById(Long id);

    AlbumEntity findEntityById(Long albumId);
}
