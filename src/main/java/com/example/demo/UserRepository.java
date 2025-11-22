package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

// Репозиторий для работы с таблицей User в базе данных
public interface UserRepository extends JpaRepository<User, Long> {}
