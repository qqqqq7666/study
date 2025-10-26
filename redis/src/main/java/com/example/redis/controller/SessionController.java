package com.example.redis.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {
    @GetMapping("/set")
    public String set(HttpSession session, @RequestParam String q) {
        session.setAttribute("q", q);

        return "saved: " + q;
    }

    @GetMapping("/get")
    public String get(HttpServletRequest request) {
        HttpSession session = request.getSession();

        return session.getAttribute("q").toString();
    }
}
