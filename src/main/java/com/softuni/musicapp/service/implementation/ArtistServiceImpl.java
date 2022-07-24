package com.softuni.musicapp.service.implementation;

import com.google.gson.Gson;
import com.softuni.musicapp.models.entities.ArtistEntity;
import com.softuni.musicapp.models.view.ArtistViewModel;
import com.softuni.musicapp.repository.ArtistRepository;
import com.softuni.musicapp.service.ArtistService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArtistServiceImpl implements ArtistService {

    private final Resource artistsFile;
    private final Gson gson;
    private final ArtistRepository artistRepository;
    private final ModelMapper modelMapper;

    public ArtistServiceImpl(@Value("classpath:init/artists.json") Resource artistsFile, Gson gson
            , ArtistRepository artistRepository, ModelMapper modelMapper) {

        this.artistsFile = artistsFile;
        this.gson = gson;
        this.artistRepository = artistRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ArtistViewModel> findAllArtists() {
        return artistRepository
                .findAll()
                .stream()
                .map(a -> modelMapper.map(a, ArtistViewModel.class)).collect(Collectors.toList());
    }

    @Override
    public void seedArtists() {
        if (artistRepository.count() == 0) {
            try {
                ArtistEntity[] artistEntities = gson.fromJson(Files.readString(Path.of(artistsFile.getURI())), ArtistEntity[].class);

                Arrays.stream(artistEntities).forEach(artistRepository::save);

            } catch (IOException e) {
                throw new IllegalStateException("Cannot seed artists");
            }
        }
    }
}
