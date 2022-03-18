package com.trainingappspringboot.demo.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class PostDTO {

    private Long id;
    private String title;
    private String subtitle;
    private String leadImage;
    private String body;
    private LocalDateTime date;
    private int count;

    public PostDTO() {
    }

    //=============================== relationships =========================================

    private User user;
    private List<PostVote> postVotes;
    private List<Comment> comments;

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

    @JsonGetter("hoursMinutes")
    public String hoursMinutes() {
        return date.format(DateTimeFormatter.ofPattern("h:mm a"));
    }

    @JsonGetter("formatDate")
    public String formatDate() {
        return date.format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
    }

    @JsonGetter("viewCount")
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @JsonIgnore
    public List<PostVote> getPostVotes() {
        return postVotes;
    }

    public void setVotes(List<PostVote> postVotes) {
        this.postVotes = postVotes;
    }

    @JsonIgnore
    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @JsonGetter("commentCount")
    public int getCommentCount() {
        if (comments != null) {
            return comments.size();
        } else {
            return 0;
        }
    }

    // ===================== VOTING LOGIC =============================================================================

    @JsonGetter("voteCount")
    public int voteCount() {
        if (postVotes != null) {
            return postVotes.stream().mapToInt(PostVote::getType).reduce(0, (sum, vote) -> sum + vote);
        } else {
            return 0;
        }
        // takes all the votes and adds 1 or -1 (getType). Needs more users in application to vote and see results.
        // http://www.baeldung.com/java-8-double-colon-operator (::)
        // stream(), mapToInt(), reduce()
        // https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html
        // A stream represents a sequence of elements and supports different kinds of operations to perform computations upon those elements.
        // Streams can be created from various data sources, especially collections. Lists and Sets support new methods stream()
        // mapToInt() returns an IntStream consisting of the results of applying the given function to the elements of this stream.
        // PostVote::getType will evaluate to a function that invokes getType() directly without any delegation.
        // There’s a really tiny performance difference due to saving one level of delegation.
        // reduce() sums the values
    }

    public void getVoteFrom(User user) {
        for (PostVote vote : postVotes) {
            if (vote.voteBelongsTo(user)) {
                setUserVote(vote.getType());
                return;
            }
        }
    }

    private int userVote;

    public int getUserVote() {
        return userVote;
    }

    public void setUserVote(int userVote) {
        this.userVote = userVote;
    }

    // ======================== MARKDOWN PARSING FOR VIEW ==============================================================

    @JsonGetter("htmlTitle")
    public String getHtmlTitle() {
        Parser parser = Parser.builder().build();
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        return renderer.render(parser.parse(title));
    }

    @JsonGetter("htmlLeadImage")
    public String getHtmlLeadImage() {
        //null checker
        if (leadImage != null) {
            Parser parser = Parser.builder().build();
            HtmlRenderer renderer = HtmlRenderer.builder().build();
            return renderer.render(parser.parse(leadImage));
        } else {
            return null;
        }
    }

    @JsonGetter("htmlSubtitle")
    public String getHtmlSubtitle() {
        Parser parser = Parser.builder().build();
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        return renderer.render(parser.parse(subtitle));
    }

    @JsonGetter("htmlBody")
    public String getHtmlBody() {
        Parser parser = Parser.builder().build();
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        return renderer.render(parser.parse(body));
    }
}

