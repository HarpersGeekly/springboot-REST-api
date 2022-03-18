package com.trainingappspringboot.demo.controllers;

import com.trainingappspringboot.demo.models.PostDTO;
import com.trainingappspringboot.demo.models.UserDTO;
import com.trainingappspringboot.demo.services.PostService;
import com.trainingappspringboot.demo.services.UserService;
import com.trainingappspringboot.demo.utils.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController // includes @ResponseBody
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:8888/", maxAge = 3600)
public class UsersRestController {

    private UserService userSvc;
    private PostService postSvc;

    @Autowired
    public UsersRestController(UserService userSvc, PostService postSvc) {
        this.userSvc = userSvc;
        this.postSvc = postSvc;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/authenticate")
    public UserDTO authenticate(@RequestBody UserDTO user) {
        // validate
        System.out.println(user);
        String username = user.getUsername();
        String password = user.getPassword();
        UserDTO existingUser = userSvc.findByUsername(username);
        boolean valid = existingUser != null && existingUser.getPassword().equals(password);
        if (valid) {
            return userSvc.authenticate(user);
        } else {
            return null;
        }
    }

    @GetMapping(value = "/users")
    public List<UserDTO> findAll() {
        return userSvc.findAll();
    }

    @GetMapping(value = "/id/{id}")
    public UserDTO findById(@PathVariable(name = "id") Long id) {
        try {
            userSvc.findOne(id);
        } catch (Exception e) {
            throw new ResourceNotFoundException();
        }
        return userSvc.findOne(id);
    }

    @GetMapping(value = "/username/{username}")
    public UserDTO findByUsername(@PathVariable(name = "username") String username) {
        try {
            userSvc.findByUsername(username);
        } catch (Exception e) {
            throw new ResourceNotFoundException();
        }
        return userSvc.findByUsername(username);
    }

    @GetMapping(value = "/email")
    public UserDTO findByEmail(@RequestParam(name = "email") String email) {
        try {
            userSvc.findByEmail(email);
        } catch (Exception e) {
            throw new ResourceNotFoundException();
        }
        return userSvc.findByEmail(email);
    }

//---------------------- Save User ------------------------------------------------------

    @PostMapping(value = "/saveUser")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO saveUser(@RequestBody UserDTO user) {
        user.setDate(LocalDateTime.now());
        return userSvc.saveUser(user);
    }

//---------------------- Update User ---------------------------------------------------

    @PutMapping(value = "/editUser")
    public UserDTO updateUser(@RequestBody UserDTO user) {
        return userSvc.updateUser(user);
    }

//--------------------- Delete User ----------------------------------------------------

    @DeleteMapping(value = "/deleteUser/{id}")
//    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        try {
            UserDTO user = userSvc.findOne(id);
            List<PostDTO> posts = postSvc.findAllByUserId(id);
            for (PostDTO p : posts) {
                postSvc.delete(p);
            }
            userSvc.delete(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}


//    //-------------------Retrieve Single User--------------------------------------------------------
//
//    @RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<User> getUser(@PathVariable("id") long id) {
//        System.out.println("Fetching User with id " + id);
//        User user = userSvc.findOne(id);
//        if (user == null) {
//            System.out.println("User with id " + id + " not found");
//            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<User>(user, HttpStatus.OK);
//    }
//
// IS THE SAME AS...
//----------------------- Get User -------------------------------------------------------

//    @Deprecated
//    @GetMapping(value = "/getUser/{id}")
//    public ObjectNode fetchUserToJson(@PathVariable(name="id") long id) {
//        User user = userSvc.findOne(id);
//        return userSvc.toJson(user);
//    }

//    @GetMapping(value = "/getUser/{id}")
//    public User fetchUser(@PathVariable(name = "id") long id) {
//        return userSvc.findOne(id);
//    }

