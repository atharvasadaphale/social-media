package com.example.TestSpring2Module.Service;

import com.example.TestSpring2Module.Entites.Post;
import com.example.TestSpring2Module.Repository.PostRepository;
import jakarta.persistence.PostRemove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;
    public String addPost(Post post) throws Exception{

        postRepository.save(post);
        return "Post Added Successfully";
    }
}
