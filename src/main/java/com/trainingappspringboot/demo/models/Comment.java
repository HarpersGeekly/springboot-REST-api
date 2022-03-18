package com.trainingappspringboot.demo.models;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    // required. Hibernate maps this attribute to a table column named "id". It then maps the following fields automagically
    @GeneratedValue(strategy = GenerationType.IDENTITY) //enable auto ID generation
    private Long id;

    @NotBlank(message = "Comments cannot be empty.")
    @Length(max = 1500, message = "Comments must be at least 1500 characters.")
    private String body;

    private LocalDateTime date;

    private boolean hasBeenDeleted;

    @ManyToOne
    private User user;

    @ManyToOne
    private Post post;

    public Comment() {
    }

    public Comment(String body, LocalDateTime date, User user) {
        this.body = body;
        this.date = date;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public boolean isHasBeenDeleted() {
        return hasBeenDeleted;
    }

    public void setHasBeenDeleted(boolean hasBeenDeleted) {
        this.hasBeenDeleted = hasBeenDeleted;
    }
}
