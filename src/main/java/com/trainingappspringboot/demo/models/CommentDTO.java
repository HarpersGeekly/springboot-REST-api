package com.trainingappspringboot.demo.models;

import com.fasterxml.jackson.annotation.JsonGetter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CommentDTO {

    private Long id;
    private String body;
    private LocalDateTime date;
    private boolean hasBeenDeleted;

    public CommentDTO() {
    }

    //======================== relationships =====================

    private Post post;
    private User user;

    //======================== getters & setters =================

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonGetter("hoursMinutes")
    public String hoursMinutes() {
        return date.format(DateTimeFormatter.ofPattern("h:mm a"));
    }

    @JsonGetter("formatDate")
    public String formatDate() {
        return date.format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
    }

    public boolean isHasBeenDeleted() {
        return hasBeenDeleted;
    }

    public void setHasBeenDeleted(boolean hasBeenDeleted) {
        this.hasBeenDeleted = hasBeenDeleted;
    }
}
