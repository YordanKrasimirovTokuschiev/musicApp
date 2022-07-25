package com.softuni.musicapp.repository;

import com.softuni.musicapp.models.entities.ArtistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistRepository extends JpaRepository<ArtistEntity, Long> {

    @Query("select a.name from ArtistEntity a")
    List<String> findAllArtistNames();
}
