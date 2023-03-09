package com.example.TestSpring2Module.Entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name =  "post")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String content;
    private int likes;

    @JoinColumn
    @ManyToOne
    UserEntity user;

    public void likePost() {
        this.likes ++;
    }
}
