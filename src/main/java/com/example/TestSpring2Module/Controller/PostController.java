package com.example.TestSpring2Module.Controller;

import com.example.TestSpring2Module.Entites.Post;
import com.example.TestSpring2Module.Service.PostService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("post")
public class PostController {
    @Autowired
    PostService postService;

    @PostMapping("post")
    public ResponseEntity addPost(@RequestBody Post post, @RequestParam("id") int userId) throws Exception{
        try {
            return new ResponseEntity(postService.addPost(post), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage().toString(), HttpStatus.BAD_REQUEST);
        }
    }
}
