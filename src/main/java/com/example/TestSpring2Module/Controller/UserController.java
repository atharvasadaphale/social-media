package com.example.TestSpring2Module.Controller;

import com.example.TestSpring2Module.Entites.UserEntity;
import com.example.TestSpring2Module.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("addUser")
    public ResponseEntity addUser(@RequestBody UserEntity user) throws Exception{
        try {
            return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage().toString(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("likePost")
    public ResponseEntity likePost(@RequestParam int userId, @RequestParam int postId) {
        try {
            return new ResponseEntity<>(userService.likePost(userId, postId), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage().toString(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("getMaxLikes")
    public ResponseEntity getMaxLikes() throws Exception{
        try {
            return new ResponseEntity<>(userService.getMaxLikes(), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage().toString(), HttpStatus.BAD_REQUEST);
        }
    }
}
