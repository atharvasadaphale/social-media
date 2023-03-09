package com.example.TestSpring2Module.Service;

import com.example.TestSpring2Module.Entites.Notification;
import com.example.TestSpring2Module.Entites.Post;
import com.example.TestSpring2Module.Entites.UserEntity;
import com.example.TestSpring2Module.Repository.PostRepository;
import com.example.TestSpring2Module.Repository.UserRepository;
import com.example.TestSpring2Module.ResponseDto.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;

    public String addUser(UserEntity user) throws Exception {
        userRepository.save(user);
        return "User Added Successfully";
    }

    public String likePost(int userId, int postId) throws Exception {
        UserEntity user = userRepository.findById(userId).get();

        if(user == null) throw new Exception("No user exists with given ID ! ");

        Post post = postRepository.findById(postId).get();
        if(post == null) throw new Exception("No post exists with given ID ! ");

        if(!user.getPostList().contains(post)) throw new Exception ("Post does not belongs to that user !");
        post.likePost();

        userRepository.save(user);


        UserEntity mainUser = post.getUser();
        Notification notification=  new Notification();
        notification.setUser(mainUser);
        mainUser.getNotificationList().add(new Notification());
        userRepository.save(mainUser);

        return "Post Liked !!";
    }

    public UserResponseDto getMaxLikes() throws Exception {
        List<UserEntity> userEntityList = userRepository.findAll().stream().toList();
        UserEntity user = null;
        int maxLikes = -1;

        for(UserEntity curr : userEntityList) {
            if(curr.getNotificationList().size() >  maxLikes) {
                maxLikes = curr.getNotificationList().size();
                user = curr;
            }
        }

        if(user == null) throw new Exception("No users are there !");

        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setAge(user.getAge());
        userResponseDto.setName(user.getName());

        return userResponseDto;
    }
}
