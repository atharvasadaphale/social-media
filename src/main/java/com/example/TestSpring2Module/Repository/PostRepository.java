package com.example.TestSpring2Module.Repository;

import com.example.TestSpring2Module.Entites.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
}

