package ru.kndm.jdbc.peristence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kndm.jdbc.peristence.entity.Gist;

import java.util.List;

@Repository
public interface GistRepository extends JpaRepository<Gist, Long> {

    // Автоматически генерируемый реактивный запрос
    List<Gist> findByAuthor(String author);

    // Кастомный запрос с @Query
    @Query("FROM Gist WHERE title LIKE :title")
    List<Gist> findByTitleLike(String title);
}
