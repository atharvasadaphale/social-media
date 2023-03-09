package com.example.TestSpring2Module.Repository;

import com.example.TestSpring2Module.Entites.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>{

}
