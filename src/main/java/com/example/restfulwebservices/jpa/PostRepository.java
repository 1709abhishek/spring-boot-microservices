package com.example.restfulwebservices.jpa;

import com.example.restfulwebservices.users.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
