package com.softuni.musicapp.service;

import com.softuni.musicapp.models.entities.ArtistEntity;
import com.softuni.musicapp.models.view.ArtistViewModel;

import java.util.List;

public interface ArtistService {

    List<String> findAllArtists();
    void seedArtists();

    ArtistEntity findByName(String artist);
}
