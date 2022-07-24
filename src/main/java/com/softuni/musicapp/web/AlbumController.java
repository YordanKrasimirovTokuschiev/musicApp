package com.softuni.musicapp.web;

import com.softuni.musicapp.models.binding.AlbumAddBindingModel;
import com.softuni.musicapp.models.service.AlbumServiceModel;
import com.softuni.musicapp.service.AlbumService;
import com.softuni.musicapp.service.ArtistService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/albums")
public class AlbumController {

    private final AlbumService albumService;
    private final ModelMapper modelMapper;
    private final ArtistService artistService;

    public AlbumController(AlbumService albumService, ModelMapper modelMapper, ArtistService artistService) {
        this.albumService = albumService;
        this.modelMapper = modelMapper;
        this.artistService = artistService;
    }

    @ModelAttribute("albumAddBindingModel")
    public AlbumAddBindingModel createBindingModel() {
        return new AlbumAddBindingModel();
    }

    @GetMapping("/add")
    public Model addAlbum(Model model) {

        model.addAttribute("artist", artistService.findAllArtists());

        return model;
    }

    @PostMapping("/add")
    public String addAlbum(AlbumAddBindingModel albumAddBindingModel,
                           @AuthenticationPrincipal UserDetails principal) {

        AlbumServiceModel albumServiceModel = modelMapper.map(albumAddBindingModel, AlbumServiceModel.class);

        albumServiceModel.setUsername(principal.getUsername());

        albumService.createAlbum(albumServiceModel);

        return "redirect:/home";
    }
}
