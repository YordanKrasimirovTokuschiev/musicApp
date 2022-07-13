package com.softuni.musicapp.web;

import com.softuni.musicapp.models.view.AlbumViewModel;
import com.softuni.musicapp.repository.AlbumRepository;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/albums")
@RestController
public class AlbumRestController {

    private final AlbumRepository albumRepository;
    private final ModelMapper modelMapper;

    public AlbumRestController(AlbumRepository albumRepository, ModelMapper modelMapper) {
        this.albumRepository = albumRepository;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/api")
    public List<AlbumViewModel> findAll() {
       return albumRepository
               .findAll()
               .stream()
               .map(ae -> modelMapper.map(ae, AlbumViewModel.class))
               .collect(Collectors.toList());

    }
}
