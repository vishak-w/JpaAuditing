package com.example.demo.userRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.userEntity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
