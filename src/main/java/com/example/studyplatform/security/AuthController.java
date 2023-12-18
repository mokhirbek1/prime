package com.example.studyplatform.security;

import com.example.studyplatform.entity.UserService;
import com.example.studyplatform.security.dto.LoginDto;
import com.example.studyplatform.security.dto.RegisterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute RegisterDto registerDto) {
        userService.register(registerDto);
        return "redirect:/auth/login";
    }

    @GetMapping("/home")
    public String home(@ModelAttribute LoginDto loginDto){
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
