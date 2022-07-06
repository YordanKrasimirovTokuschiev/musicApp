package com.softuni.musicapp.models.binding;

import com.softuni.musicapp.models.validators.FieldMatch;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@FieldMatch(
        first = "password",
        second = "password"
)
public class UserRegisterBindingModel {

    @NotEmpty
    @Size(min = 3)
    private String username;

    @NotEmpty
    @Size(min = 3)
    private String fullName;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    @Size(min = 5, max = 20)
    private String password;

    @NotEmpty
    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public UserRegisterBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserRegisterBindingModel setFullName(String fullname) {
        this.fullName = fullname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
