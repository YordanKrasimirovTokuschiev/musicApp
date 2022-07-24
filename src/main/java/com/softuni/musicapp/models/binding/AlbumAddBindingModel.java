package com.softuni.musicapp.models.binding;

import com.softuni.musicapp.models.entities.enums.Genre;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AlbumAddBindingModel {

     private String name;
     private String imageUrl;
     private String videoUrl;
     private String description;
     private Integer copies;
     private BigDecimal price;
     private LocalDate releaseDate;
     private Genre genre;


     public String getName() {
          return name;
     }

     public AlbumAddBindingModel setName(String name) {
          this.name = name;
          return this;
     }

     public String getImageUrl() {
          return imageUrl;
     }

     public AlbumAddBindingModel setImageUrl(String imageUrl) {
          this.imageUrl = imageUrl;
          return this;
     }

     public String getVideoUrl() {
          return videoUrl;
     }

     public AlbumAddBindingModel setVideoUrl(String videoUrl) {
          this.videoUrl = videoUrl;
          return this;
     }

     public String getDescription() {
          return description;
     }

     public AlbumAddBindingModel setDescription(String description) {
          this.description = description;
          return this;
     }

     public Integer getCopies() {
          return copies;
     }

     public AlbumAddBindingModel setCopies(Integer copies) {
          this.copies = copies;
          return this;
     }

     public BigDecimal getPrice() {
          return price;
     }

     public AlbumAddBindingModel setPrice(BigDecimal price) {
          this.price = price;
          return this;
     }

     public LocalDate getReleaseDate() {
          return releaseDate;
     }

     public AlbumAddBindingModel setReleaseDate(LocalDate releaseDate) {
          this.releaseDate = releaseDate;
          return this;
     }
     public Genre getGenre() {
          return genre;
     }

     public AlbumAddBindingModel setGenre(Genre genre) {
          this.genre = genre;
          return this;
     }

     @Override
     public String toString() {
          return "AlbumAddBindingModel{" +
                  "name='" + name + '\'' +
                  ", imageUrl='" + imageUrl + '\'' +
                  ", videoUrl='" + videoUrl + '\'' +
                  ", description='" + description + '\'' +
                  ", copies=" + copies +
                  ", price=" + price +
                  ", releaseDate=" + releaseDate +
                  ", genre=" + genre +
                  '}';
     }
}
