package com.trainingappspringboot.demo.services;

import com.trainingappspringboot.demo.models.SecureTokenGenerator;
import com.trainingappspringboot.demo.models.User;
import com.trainingappspringboot.demo.models.UserDTO;
import com.trainingappspringboot.demo.repositories.UsersRepository;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserService {

    private UsersRepository usersDao;

    @Autowired
    public UserService(UsersRepository usersDao) {
        this.usersDao = usersDao;
    }

    public List<UserDTO> findAll() {
        List<User> users = usersDao.findAll();
        List<UserDTO> dtos = new ArrayList<>();
        for (User u : users) {
            UserDTO converted = convertToUserDTO(u);
            dtos.add(converted);
        }
        return dtos;
    }

    public UserDTO findOne(Long id) {
        User user = usersDao.findById(id);
        return convertToUserDTO(user);
    }

    public UserDTO authenticate(UserDTO dto) {
        User user = usersDao.findByUsername(dto.getUsername());
        UserDTO responseUser = convertToUserDTO(user);
        String token = SecureTokenGenerator.nextToken();
//        String token =  UUID.randomUUID().toString();
        System.out.println("token to give: " + token);
        responseUser.setToken(token);
        System.out.println("converted user: " + responseUser.toString());
        return responseUser;
    }

    public UserDTO findByUsername(String username) {
        User user = usersDao.findByUsername(username);
        if (user == null) {
            return null;
        }
        return convertToUserDTO(user);
    }

    public UserDTO findByEmail(String email) {
        User user = usersDao.findByEmail(email);
        if (user == null) {
            return null;
        }
        return convertToUserDTO(user);
    }

    public UserDTO saveUser(UserDTO user) {
        User entity = convertToUser(user);
        //hash password
        usersDao.save(entity);
        return convertToUserDTO(entity);
    }

    public UserDTO updateUser(UserDTO user) {
        User existingUser = usersDao.findById(user.getId());
        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(user.getEmail());
        existingUser.setBio(user.getBio());
        return convertToUserDTO(existingUser);
    }

    public void delete(UserDTO dto) {
        User user = convertToUser(dto);
        usersDao.delete(user);
    }

    public UserDTO convertToUserDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setBio(user.getBio());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        dto.setDate(user.getDate());
        return dto;
    }

    public User convertToUser(UserDTO userDto) {
        User entity = new User();
        entity.setId(userDto.getId());
        entity.setUsername(userDto.getUsername());
        entity.setEmail(userDto.getEmail());
        entity.setBio(userDto.getBio());
        entity.setPassword(userDto.getPassword());
        entity.setDate(userDto.getDate());
        return entity;
    }

    public ObjectNode toJson(User user) {
//        List<Post> posts = user.getPosts();
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode userNode = mapper.valueToTree(user);
//        ArrayNode postArray = mapper.valueToTree(posts);
//        userNode.putArray("posts").addAll(postArray);
        JsonNode result = mapper.createObjectNode().set("user", userNode);
        return (ObjectNode) result;
    }

    public Object fromJson(String jsonString, Object valueType) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonString, (JavaType) valueType);
    }


}