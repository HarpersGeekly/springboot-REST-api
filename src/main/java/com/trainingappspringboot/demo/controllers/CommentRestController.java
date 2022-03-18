package com.trainingappspringboot.demo.controllers;

import com.trainingappspringboot.demo.models.CommentDTO;
import com.trainingappspringboot.demo.services.CommentService;
import com.trainingappspringboot.demo.utils.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/comment")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class CommentRestController {

    private CommentService commentSvc;

    @Autowired
    public CommentRestController(CommentService commentSvc) {
        this.commentSvc = commentSvc;
    }

    // ------------------- Find Comment(s) ------------------------------

    @GetMapping("/commentsByPost/{postId}")
    public List<CommentDTO> getCommentsByPost(@PathVariable Long postId) {
        try {
            commentSvc.findAllByPostId(postId);
        } catch (Exception e) {
            throw new ResourceNotFoundException();
        }
        return commentSvc.findAllByPostId(postId);
    }

    @GetMapping("/commentsByUser/{userId}")
    public List<CommentDTO> getCommentsByUser(@PathVariable Long userId) {
        try {
            commentSvc.findAllByUserId(userId);
        } catch (Exception e) {
            throw new ResourceNotFoundException();
        }
        return commentSvc.findAllByUserId(userId);
    }

    // ------------------- Save Comment --------------------------------

    @PostMapping("/saveComment")
    @ResponseStatus(HttpStatus.CREATED)
    public CommentDTO saveComment(@RequestBody CommentDTO comment) {
        System.out.println("comment coming over " + comment);
        comment.setDate(LocalDateTime.now());
        return commentSvc.saveComment(comment);
    }

    // ------------------- Delete Comment ------------------------------

    @DeleteMapping("/deleteComment/{id}")
    public CommentDTO deleteById(@PathVariable Long id) {
        CommentDTO commentDto = commentSvc.findOne(id);
        return commentSvc.delete(commentDto);
    }

    // ------------------- Edit Comment ------------------------------


}
