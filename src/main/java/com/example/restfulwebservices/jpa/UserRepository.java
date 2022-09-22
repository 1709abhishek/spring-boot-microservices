package com.example.restfulwebservices.jpa;

import com.example.restfulwebservices.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
