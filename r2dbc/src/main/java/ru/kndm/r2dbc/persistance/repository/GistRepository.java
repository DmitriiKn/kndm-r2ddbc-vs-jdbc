package ru.kndm.r2dbc.persistance.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import ru.kndm.r2dbc.persistance.entity.Gist;

public interface GistRepository extends ReactiveCrudRepository<Gist, Long> {

    // Автоматически генерируемый реактивный запрос
    Flux<Gist> findByAuthor(String author);

    // Кастомный запрос с @Query
    @Query("SELECT * FROM gist WHERE title LIKE :title")
    Flux<Gist> findByTitleLike(String title);
}
