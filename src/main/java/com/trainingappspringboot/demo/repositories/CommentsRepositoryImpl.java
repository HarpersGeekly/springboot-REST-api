package com.trainingappspringboot.demo.repositories;

import com.trainingappspringboot.demo.models.Comment;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public class CommentsRepositoryImpl extends AbstractDao<Long, Comment> {

//    public Comment findOne(long id) {
//        return getByKey(id);
//    }
//
//    @SuppressWarnings("unchecked")
//    public List<Comment> findAllByPostId(long id) {
//        Query query = createCustomQuery("FROM Comment WHERE post_id =" + id);
//        return query.list();
//    }
//
//    @SuppressWarnings("unchecked")
//    public List<Comment> findAllByUserId(long id) {
//        Query query = createCustomQuery("FROM Comment WHERE user_id =" + id);
//        return query.list();
//    }
//
//    public void saveComment(Comment comment) {
//        save(comment);
//    }
}
