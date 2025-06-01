package dev.lavalink.config.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping(value = "/login", produces = "text/html;charset=UTF-8")
    public String login() {
        return "login";
    }

}
