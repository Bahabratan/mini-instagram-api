package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Получить всех пользователей
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Добавить нового пользователя (POST)
    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    // Обновить данные пользователя (PUT через body)
    @PutMapping
    public User updateUser(@RequestBody User updatedUser) {
        if (updatedUser.getId() == null) {
            throw new RuntimeException("ID міндетті түрде керек жаңарту үшін!");
        }

        return userRepository.findById(updatedUser.getId())
                .map(user -> {
                    if (updatedUser.getName() != null) user.setName(updatedUser.getName());
                    return userRepository.save(user);
                })
                .orElseThrow(() -> new RuntimeException("Пайдаланушы табылмады (ID = " + updatedUser.getId() + ")"));
    }

    // Удалить пользователя через body
    @DeleteMapping
    public String deleteUser(@RequestBody User user) {
        if (user.getId() == null) {
            return "ID міндетті түрде керек өшіру үшін!";
        }

        if (!userRepository.existsById(user.getId())) {
            return "Мұндай ID бар пайдаланушы табылмады: " + user.getId();
        }

        userRepository.deleteById(user.getId());
        return "Пайдаланушы өшірілді (ID = " + user.getId() + ")";
    }
}
