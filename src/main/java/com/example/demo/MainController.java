package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    // Обычный маршрут
    @GetMapping("/main")
    public String mainPage(@RequestParam(required = false, defaultValue = "қонақ") String name) {
        return "Сәлем, " + name + "! Бұл Main беті.";
    }
}
