package com.trainingappspringboot.demo.models;

import com.fasterxml.jackson.annotation.JsonGetter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//Data transfer object. Web "service object" that converts from json to persistent entity object User
public class UserDTO {

    private Long id;
    private String username;
    private String email;
    private String bio;
    private String password;
    private LocalDateTime date;
    private String token;

    public UserDTO() {
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", bio='" + bio + '\'' +
                ", password='" + password + '\'' +
                ", date=" + date + '\'' +
                ", token=" + token +
                '}';
    }

//    ============================ getters and setters =====================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @JsonGetter("hoursMinutes")
    public String hoursMinutes() {
        return date.format(DateTimeFormatter.ofPattern("h:mm a"));
    }

    @JsonGetter("formatDate")
    public String formatDate() {
        return date.format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
