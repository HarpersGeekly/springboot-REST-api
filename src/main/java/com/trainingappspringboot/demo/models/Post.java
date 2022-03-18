package com.trainingappspringboot.demo.models;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Entity // annotation saying "will be a table", an entity in the database
@Table(name = "posts")
// name of database table, required for query syntax in Hibernate (org.hibernate.hql.internal.ast.QuerySyntaxException)
public class Post {

    @Id
    // required. Hibernate maps this attribute to a table column named "id". It then maps the following fields automagically
    @GeneratedValue(strategy = GenerationType.IDENTITY) //enable auto ID generation
    private Long id;

    @NotBlank(message = "Title cannot be empty.")
    @Length(min = 5, max = 100, message = "Title must be between 5-100 characters.")
    private String title;

    @NotBlank(message = "Subtitle cannot be empty.")
    @Length(min = 5, max = 200, message = "Subtitle must be between 5-200 characters.")
    private String subtitle;

    private String leadImage;

    @Column(columnDefinition = "TEXT", length = 50000, nullable = false)
    @NotBlank(message = "Post body cannot be empty.")
    @Length(min = 5, max = 50000, message = "Description must be between 5-50000 characters.")
    private String body;

    @Column(name = "created_date")
    private LocalDateTime date;

    public Post() {
    }

    public Post(Long id, String title, String subtitle, String leadImage, String body, User user, LocalDateTime date,
                List<PostVote> postVotes
    ) {
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
        this.leadImage = leadImage;
        this.body = body;
        this.user = user;
        this.date = date;
        this.postVotes = postVotes;
    }

    //=============================== relationships =========================================

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL) // .ALL needed for saving in db.
    private List<PostVote> postVotes;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    // one user can have many comments. When User is deleted, these delete too
    private List<Comment> comments;

    public void addVote(PostVote vote) {
        postVotes.add(vote);
    }

    public void removeVote(PostVote vote) {
        postVotes.remove(vote);
    }

    public PostVote getVoteFrom(User user) {
        for (PostVote vote : postVotes) {
            if (vote.voteBelongsTo(user)) {
                return vote;
            }
        }
        return null;
    }

    //=============================== getters and setters =========================================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getLeadImage() {
        return leadImage;
    }

    public void setLeadImage(String leadImage) {
        this.leadImage = leadImage;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
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

    public List<PostVote> getPostVotes() {
        return postVotes;
    }

    public void setPostVotes(List<PostVote> postVotes) {
        this.postVotes = postVotes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
