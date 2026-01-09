package ru.kndm.r2dbc.persistance.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import java.time.Instant;

@Table("gist")  // Явно указываем имя таблицы
public record Gist(
        @Id
        Long id,

        @Column("title")
        String title,

        @Column("content")
        String content,

        @Column("author")
        String author,

        @Column("created_at")
        Instant createdAt
) {
    // Статический фабричный метод для создания нового Gist
    public static Gist create(String title, String content, String author) {
        return new Gist(null, title, content, author, Instant.now());
    }

    // Метод для обновления содержимого
    public Gist withContent(String newContent) {
        return new Gist(this.id, this.title, newContent, this.author, this.createdAt);
    }

    // Метод для обновления заголовка
    public Gist withTitle(String newTitle) {
        return new Gist(this.id, newTitle, this.content, this.author, this.createdAt);
    }
}