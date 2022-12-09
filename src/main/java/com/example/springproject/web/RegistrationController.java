package com.example.springproject.web;

import com.example.springproject.domain.user.UserService;
import com.example.springproject.domain.user.dto.UserRegistrationDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/rejestracja")
    public String registrationForm(Model model){
        UserRegistrationDto userRegistartion = new UserRegistrationDto();
        model.addAttribute("user", userRegistartion);
        return "registration-form";
    }
    @PostMapping("/rejestracja")
    public String register(UserRegistrationDto userRegistrationDto){
        userService.registerUserWithDefaultRole(userRegistrationDto);
        return "redirect:/";
    }
}
