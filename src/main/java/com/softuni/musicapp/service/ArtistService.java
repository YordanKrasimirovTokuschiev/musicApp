package com.softuni.musicapp.service;

import com.softuni.musicapp.models.view.ArtistViewModel;

import java.util.List;

public interface ArtistService {

    List<ArtistViewModel> findAllArtists();
    void seedArtists();
}
