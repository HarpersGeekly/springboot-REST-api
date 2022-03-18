package com.trainingappspringboot.demo.repositories;

import com.trainingappspringboot.demo.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsRepository extends JpaRepository<Comment, Integer> {

    Comment findById(long id);

    List<Comment> findAllByPostId(long id);

    List<Comment> findAllByUserId(long id);

    List<Comment> findAllByUserIdAndHasBeenDeletedIsFalse(long id);

    Comment save(Comment comment);
}
