package com.softuni.musicapp.service.implementation;

import com.softuni.musicapp.models.entities.AlbumEntity;
import com.softuni.musicapp.models.entities.ArtistEntity;
import com.softuni.musicapp.models.entities.UserEntity;
import com.softuni.musicapp.models.service.AlbumServiceModel;
import com.softuni.musicapp.models.view.AlbumViewModel;
import com.softuni.musicapp.repository.AlbumRepository;
import com.softuni.musicapp.repository.UserRepository;
import com.softuni.musicapp.service.AlbumService;
import com.softuni.musicapp.service.ArtistService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;
    private final UserRepository userRepository;
    private final ArtistService artistService;
    private final ModelMapper modelMapper;

    public AlbumServiceImpl(AlbumRepository albumRepository, UserRepository userRepository, ArtistService artistService, ModelMapper modelMapper) {
        this.albumRepository = albumRepository;
        this.userRepository = userRepository;
        this.artistService = artistService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void createAlbum(AlbumServiceModel serviceModel) {
        AlbumEntity albumEntity = modelMapper.map(serviceModel, AlbumEntity.class);
        UserEntity creator = userRepository
                .findByUsername(serviceModel.getUser())
                .orElseThrow(() -> new IllegalArgumentException("Creator " + serviceModel.getUser() + " could not be found"));
        albumEntity.setUserEntity(creator);

        ArtistEntity artistEntity = artistService
                .findByName(serviceModel.getArtist());

        albumEntity.setArtistEntity(artistEntity);

        albumRepository.save(albumEntity);
    }

    @Override
    public AlbumViewModel findById(Long id) {
        return albumRepository
                .findById(id)
                .map(albumEntity -> {
                    AlbumViewModel albumViewModel = modelMapper
                            .map(albumEntity, AlbumViewModel.class);
                    albumViewModel.setArtist(albumEntity.getArtistEntity().getName());
                    return albumViewModel;
                })
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public AlbumEntity findEntityById(Long albumId) {
        return albumRepository
                .findById(albumId)
                .orElseThrow(IllegalArgumentException::new);
    }
}
