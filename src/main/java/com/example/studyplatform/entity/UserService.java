package com.example.studyplatform.entity;

import com.example.studyplatform.entity.user.User;
import com.example.studyplatform.entity.user.UserRole;
import com.example.studyplatform.security.dto.RegisterDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String phoneNumber) {
        System.out.println("phone number ="+phoneNumber);
        return (UserDetails) userRepository.findByPhoneNumber(phoneNumber).orElseThrow();
    }

    @Transactional
    public void register(RegisterDto dto) {
        User user = new User(null, dto.getPhoneNumber(), dto.getPassword(), UserRole.STUDENT);
        userRepository.save(user);
    }
}
