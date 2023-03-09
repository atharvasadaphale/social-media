package com.example.TestSpring2Module.Service;

import com.example.TestSpring2Module.Entites.Post;
import com.example.TestSpring2Module.Entites.UserEntity;
import com.example.TestSpring2Module.Repository.PostRepository;
import com.example.TestSpring2Module.Repository.UserRepository;
import jakarta.persistence.PostRemove;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;
    public String addPost(Post post) throws Exception {
        // Check if the user who posted the post exists
        UserEntity user = post.getUser();
        if (!userExists(user.getId())) {
            throw new Exception("User does not exist");
        }

        // Add the post to the user's list of posts
        List<Post> Posts = UserEntity.getPostList() ;
        Posts.add(post);

        // Save the post to the database
        postRepository.save(post);

        return "Post Added Successfully";
    }

    private boolean userExists(int userId) {

        UserEntity userEntity = userRepository.findById(userId).get();
        if(userEntity == null){
            return false;
        }
        return true;
    }
}
