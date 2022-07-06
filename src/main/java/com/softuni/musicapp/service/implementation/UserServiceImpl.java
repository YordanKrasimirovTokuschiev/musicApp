package com.softuni.musicapp.service.implementation;

import com.softuni.musicapp.models.entities.UserEntity;
import com.softuni.musicapp.models.entities.UserRoleEntity;
import com.softuni.musicapp.models.entities.enums.UserRole;
import com.softuni.musicapp.models.service.UserRegisterServiceModel;
import com.softuni.musicapp.repository.UserRepository;
import com.softuni.musicapp.repository.UserRoleRepository;
import com.softuni.musicapp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final MusicDBUserService musicDBUserService;

    public UserServiceImpl(UserRepository userRepository, UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper, MusicDBUserService musicDBUserService) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
        this.musicDBUserService = musicDBUserService;
    }

    @Override
    public void seedUsers() {

        if (userRepository.count() == 0) {

            UserRoleEntity adminRole = new UserRoleEntity().setRole(UserRole.ADMIN);
            UserRoleEntity userRole = new UserRoleEntity().setRole(UserRole.USER);

            userRoleRepository.saveAll(List.of(adminRole, userRole));

            UserEntity admin = new UserEntity().setUsername("admin").setFullName("Admin Adminov").setPassword("123456");
            admin.setPassword(passwordEncoder.encode(admin.getPassword()));
            UserEntity user = new UserEntity().setUsername("user").setFullName("Bai Ivan").setPassword("123456");
            user.setPassword(passwordEncoder.encode(user.getPassword()));

            admin.setRoles(List.of(adminRole, userRole));
            user.setRoles(List.of(userRole));

            userRepository.saveAll(List.of(admin, user));
        }
    }

    @Override
    public void registerAndLoginUser(UserRegisterServiceModel serviceModel) {
        UserEntity newUser = modelMapper.map(serviceModel, UserEntity.class);
        newUser.setPassword(passwordEncoder.encode(serviceModel.getPassword()));

        UserRoleEntity userRole = userRoleRepository
                .findByRole(UserRole.USER)
                .orElseThrow(() -> new IllegalStateException("USER role not found! Please seed the roles"));

        newUser.addRole(userRole);
        newUser = userRepository.save(newUser);

        UserDetails principal = musicDBUserService.loadUserByUsername(newUser.getUsername());

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                principal,
                newUser.getPassword(),
                principal.getAuthorities()
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    @Override
    public boolean userNameExists(String username) {
        return userRepository.findByUsername(username).isPresent();
    }
}
