package com.softuni.musicapp.service.implementation;

import com.softuni.musicapp.models.entities.AlbumEntity;
import com.softuni.musicapp.models.entities.UserEntity;
import com.softuni.musicapp.models.service.AlbumServiceModel;
import com.softuni.musicapp.repository.AlbumRepository;
import com.softuni.musicapp.repository.UserRepository;
import com.softuni.musicapp.service.AlbumService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public AlbumServiceImpl(AlbumRepository albumRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.albumRepository = albumRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void createAlbum(AlbumServiceModel serviceModel) {
        AlbumEntity albumEntity = modelMapper.map(serviceModel, AlbumEntity.class);
        UserEntity creator = userRepository
                .findByUsername(serviceModel.getUsername())
                        .orElseThrow(() -> new IllegalArgumentException("Creator " + serviceModel.getUsername() + " could not be found"));
        albumEntity.setUserEntity(creator);
        albumRepository.save(albumEntity);
    }
}
