package com.trainingappspringboot.demo.repositories;

import com.trainingappspringboot.demo.models.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

public class UsersRepositoryImpl extends AbstractDao<Long, User> {

//    @SuppressWarnings("unchecked")
//    public List<User> findAll() {
//        Criteria criteria = createEntityCriteria();
//        List<User> users = (List<User>) criteria.list();
//        for (User u : users) {
////            Hibernate.initialize(u.getPosts());
//        }
//        return users;
//    }
//
//    public User findByUsername(String username) {
//        Criteria criteria = createEntityCriteria();
//        criteria.add(Restrictions.eq("username", username));
//        return (User) criteria.uniqueResult();
//    }
//
////    public User findByUsername(String username) {
////        System.out.println("down in DAO");
////        Query query = createCustomQuery("FROM User WHERE username = :username");
////        System.out.println("user: " + (User) query.list());
////        return (User) query.list();
////    }
//
//    public User findByEmail(String email) {
//        Criteria criteria = createEntityCriteria();
//        criteria.add(Restrictions.eq("email", email));
//        return (User) criteria.uniqueResult();
////        Query query = createCustomQuery("FROM users WHERE email = :email");
////        query.setParameter("email", email);
////        User foundUser = (User) query.list().get(0);
////        if(foundUser == null) {
////            return null;
////        } else {
////            return foundUser;
////        }// why get(0)? email has a unique constraint so I'm never getting more than 1
//    }
//
//    public User findOne(long id) {
//        //        Hibernate.initialize(user.getPosts());
////        List<Post> posts = user.getPosts();
////        for(Post p : posts) {
////            Hibernate.initialize(p.getPostVotes());
////        }
////        Hibernate.initialize(user.getPostVotes());
//        return getByKey(id);
//    }
//
//    public void saveUser(User user) {
//        save(user);
//    }
}
