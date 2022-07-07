package com.softuni.musicapp.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "artists")
public class ArtistEntity extends BaseEntity {

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String careerInformation;

    public String getName() {
        return name;
    }

    public ArtistEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getCareerInformation() {
        return careerInformation;
    }

    public ArtistEntity setCareerInformation(String careerInformation) {
        this.careerInformation = careerInformation;
        return this;
    }

    @Override
    public String toString() {
        return "ArtistEntity{" +
                "name='" + name + '\'' +
                ", careerInformation='" + careerInformation + '\'' +
                '}';
    }
}
