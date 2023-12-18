package com.example.studyplatform.entity;

import com.example.studyplatform.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<Object> findByPhoneNumber(String phoneNumber);
}
