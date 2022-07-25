package com.softuni.musicapp.models.binding;

import com.softuni.musicapp.models.entities.enums.Genre;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

public class AlbumAddBindingModel {

     @Size(min = 5, max = 20)
     private String name;
     private String imageUrl;
     private String videoUrl;
     @Size(min = 5)
     private String description;
     @Min(0)
     private Integer copies;
     @DecimalMin("0")
     private BigDecimal price;
     @DateTimeFormat(pattern = "yyyy-MM-dd")
     private LocalDate releaseDate;
     @NotNull
     private Genre genre;
     @NotNull
     private String artist;


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

     public String getArtist() {
          return artist;
     }

     public AlbumAddBindingModel setArtist(String artist) {
          this.artist = artist;
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
                  ", artist='" + artist + '\'' +
                  '}';
     }
}
