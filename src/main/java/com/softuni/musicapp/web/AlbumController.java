package com.softuni.musicapp.web;

import com.softuni.musicapp.models.binding.AlbumBindingModel;
import com.softuni.musicapp.models.service.AlbumServiceModel;
import com.softuni.musicapp.service.AlbumService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/albums")
public class AlbumController {

    private final AlbumService albumService;
    private final ModelMapper modelMapper;

    public AlbumController(AlbumService albumService, ModelMapper modelMapper) {
        this.albumService = albumService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String addAlbum() {
        return "add-album";
    }

    @PostMapping("/add")
    public String addAlbum(@RequestBody AlbumBindingModel albumBindingModel,
                           @AuthenticationPrincipal UserDetails principal) {

        AlbumServiceModel albumServiceModel = modelMapper.map(albumBindingModel, AlbumServiceModel.class);

        albumServiceModel.setUsername(principal.getUsername());

        albumService.createAlbum(albumServiceModel);

        return "redirect:/home";
    }
}
