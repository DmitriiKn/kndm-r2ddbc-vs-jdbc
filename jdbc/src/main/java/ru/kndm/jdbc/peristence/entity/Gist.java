package ru.kndm.jdbc.peristence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Data
@Table(name = "gist")
@AllArgsConstructor
@NoArgsConstructor
public class Gist {

    @Id
    Long id;

    @Column(name = "title")
    String title;

    @Column(name = "content")
    String content;

    @Column(name = "author")
    String author;

    @Column(name = "created_at")
    Instant createdAt;

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
