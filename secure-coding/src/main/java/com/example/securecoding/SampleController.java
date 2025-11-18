package com.example.securecoding;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class SampleController {
    @GetMapping
    public String form() {
        return "form";
    }

    @PostMapping("/submit")
    public String handleFormSubmit(@RequestParam String name, @RequestParam("_csrf") String csrfToken) {
        log.info("Received CSRF token: {}", csrfToken);
        log.info("Receive name: {}", name);

        return "result";
    }
}
