package com.trainingappspringboot.demo.services;

import com.trainingappspringboot.demo.models.Post;
import com.trainingappspringboot.demo.models.PostDTO;
import com.trainingappspringboot.demo.repositories.PostsRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Transactional
public class PostService {

    private PostsRepository postsDao;

    @Autowired
    public PostService(PostsRepository postsDao) {
        this.postsDao = postsDao;
    }

    public List<PostDTO> findAll() {
        List<Post> posts = postsDao.findAll();
        return getPostDTOS(posts);
    }

    public List<Post> findAllOrderByIdDesc() {
        return postsDao.findAllByOrderByIdDesc();
    }

    public PostDTO findOne(Long id) {
        Post post = postsDao.findById(id);
        return convertToPostDTO(post);
    }

    public List<PostDTO> findAllByUserId(Long id) {
        List<Post> posts = postsDao.findAllByUserId(id);
        return getPostDTOS(posts);
    }

    private List<PostDTO> getPostDTOS(List<Post> posts) {
        List<PostDTO> dtos = new ArrayList<>();
        for (Post p : posts) {
            PostDTO converted = convertToPostDTO(p);
            dtos.add(converted);
        }
        return dtos;
    }

    public PostDTO savePost(PostDTO dto) {
        Post entity = convertToPost(dto);
        postsDao.save(entity);
        return convertToPostDTO(entity);
    }

    public PostDTO updatePost(PostDTO dto) {
        Post existingPost = postsDao.findById(dto.getId());
        existingPost.setTitle(dto.getTitle());
        existingPost.setSubtitle(dto.getSubtitle());
        existingPost.setLeadImage(dto.getLeadImage());
        existingPost.setBody(dto.getBody());
        postsDao.save(existingPost);
        return convertToPostDTO(existingPost);
    }

    public void delete(PostDTO dto) {
        Post post = convertToPost(dto);
        postsDao.delete(post);
    }

    public PostDTO convertToPostDTO(Post post) {
        System.out.println("comments:" + post.getComments());
        PostDTO dto = new PostDTO();
        //AtomicInteger counter = new AtomicInteger();
        //dto.setCount(counter.set(0));
        //System.out.println(counter);
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setSubtitle(post.getSubtitle());
        dto.setLeadImage(post.getLeadImage());
        dto.setBody(post.getBody());
        dto.setDate(post.getDate());
        dto.setUser(post.getUser());
        dto.setVotes(post.getPostVotes());
        dto.setComments(post.getComments());
        return dto;
    }

    public Post convertToPost(PostDTO dto) {
        Post entity = new Post();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setSubtitle(dto.getSubtitle());
        entity.setBody(dto.getBody());
        entity.setLeadImage(dto.getLeadImage());
        entity.setDate(dto.getDate());
        entity.setUser(dto.getUser());
        entity.setPostVotes(dto.getPostVotes());
        //entity.setComments(dto.getComments());
        return entity;
    }

    public String toJson(Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }

    public Object fromJson(String jsonString, Object valueType) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonString, (JavaType) valueType);
    }
}
