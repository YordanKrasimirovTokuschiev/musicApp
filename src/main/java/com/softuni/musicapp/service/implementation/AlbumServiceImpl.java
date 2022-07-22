package com.softuni.musicapp.service.implementation;

import com.softuni.musicapp.models.entities.AlbumEntity;
import com.softuni.musicapp.models.service.AlbumServiceModel;
import com.softuni.musicapp.repository.AlbumRepository;
import com.softuni.musicapp.service.AlbumService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;
    private final ModelMapper modelMapper;

    public AlbumServiceImpl(AlbumRepository albumRepository, ModelMapper modelMapper) {
        this.albumRepository = albumRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void createAlbum(AlbumServiceModel serviceModel) {
        AlbumEntity albumEntity = modelMapper.map(serviceModel, AlbumEntity.class);
        albumRepository.save(albumEntity);
    }
}
