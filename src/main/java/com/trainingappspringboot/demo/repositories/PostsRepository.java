package com.trainingappspringboot.demo.repositories;

import com.trainingappspringboot.demo.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostsRepository extends JpaRepository<Post, Integer> {

    List<Post> findAll();

    List<Post> findAllByOrderByIdDesc();

    List<Post> findAllByUserId(long id);

    Post findById(long id);

    void delete(Post post);

    Post save(Post post);
}
