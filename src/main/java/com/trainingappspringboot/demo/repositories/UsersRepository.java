package com.trainingappspringboot.demo.repositories;

import com.trainingappspringboot.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

    User findByEmail(String email);

    List<User> findAll();

    User findById(long id);

    User save(User user);

    void delete(User user);
}
