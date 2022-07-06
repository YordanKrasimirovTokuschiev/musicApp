package com.softuni.musicapp.repository;

import com.softuni.musicapp.models.entities.UserRoleEntity;
import com.softuni.musicapp.models.entities.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {

    Optional<UserRoleEntity> findByRole(UserRole role);
}
