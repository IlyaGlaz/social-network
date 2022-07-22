package org.glaz.network.http.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage() {
        return "user/login";
    }

//    @PostMapping("/login")
//    public String login(Model model, @ModelAttribute("login") LoginDto loginDto) {
//        return "redirect:/login";
//    }
}
