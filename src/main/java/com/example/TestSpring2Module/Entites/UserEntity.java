package com.example.TestSpring2Module.Entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Notification> notificationList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Post> postList;
}
