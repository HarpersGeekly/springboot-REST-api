package com.trainingappspringboot.demo.repositories;

import com.trainingappspringboot.demo.models.Post;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public class PostsRepositoryImpl extends AbstractDao<Long, Post> {

//    @SuppressWarnings("unchecked")
//    public List<Post> findAll() {
//        Criteria criteria = createEntityCriteria();
//        List<Post> posts = (List<Post>) criteria.list();
//        for (Post p : posts) {
//            Hibernate.initialize(p.getPostVotes());
//        }
//        return posts;
//    }
//
//    @SuppressWarnings("unchecked")
//    public List<Post> findAllOrderByIdDesc() {
//        Query query = createCustomQuery("FROM Post ORDER BY id DESC");
//        query.setMaxResults(3);
//        return query.list();
//    }
//
//    @SuppressWarnings("unchecked")
//    public List<Post> findAllByUserId(long id) {
//        Query query = createCustomQuery("FROM Post WHERE user_id = " + id);
//        List<Post> posts = query.list();
//        for (Post p : posts) {
//            Hibernate.initialize(p.getPostVotes());
//        }
//        return posts;
//    }
//
//    public Post findPost(long id) {
//        return getByKey(id);
//    }
//
////    @SuppressWarnings("unchecked")
////    public List<Post> latestPosts() {
////        Criteria criteria = createEntityCriteria();
////        return (List<Post>) criteria.list();
////    }
//
//    public Post findOne(long id) {
//        Post post = getByKey(id);
//        Hibernate.initialize(post.getPostVotes());
//        return post;
//    }
//
//    public void savePost(Post post) {
//        save(post);
//    }
//
//    public void updatePost(Post post) {
//        update(post);
//    }
//
////    public void updatePost(Post post) {
////        Query query = createCustomQuery("UPDATE Post set body = :body, title = :title, subtitle = :subtitle, leadImage = :leadImage WHERE ID = :id");
////        query.setParameter("id", post.getId());
////        query.setParameter("body", post.getBody());
////        query.setParameter("title", post.getTitle());
////        query.setParameter("subtitle", post.getSubtitle());
////        query.setParameter("leadImage", post.getLeadImage());
////        query.executeUpdate();
////    }
}


