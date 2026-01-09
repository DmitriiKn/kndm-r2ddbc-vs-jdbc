package ru.kndm.r2dbc.persistance.entity;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public record Gist(@Id Long id, String title, String content, String author, LocalDateTime createdAt) {}
