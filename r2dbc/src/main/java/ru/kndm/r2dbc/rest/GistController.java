package ru.kndm.r2dbc.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.kndm.r2dbc.persistance.entity.Gist;
import ru.kndm.r2dbc.persistance.repository.GistRepository;

@RestController
@RequestMapping("api/v1/gists")
@RequiredArgsConstructor
@Slf4j
public class GistController {

    private final GistRepository gistRepository;

    @GetMapping
    public Flux<Gist> getAllGists() {
        return Flux.defer(() -> {
            log.debug("Processing request on thread: {}", Thread.currentThread().getName());
            return gistRepository.findAll()
                    .doOnSubscribe(s -> log.debug("Subscribed to repository on thread: {}",
                            Thread.currentThread().getName()));
        });
    }

    @GetMapping("/{id}")
    public Mono<Gist> getGist(@PathVariable Long id) {
        return gistRepository.findById(id);
    }

    @PostMapping
    public Mono<Gist> createGist(@RequestBody Gist gist) {
        return gistRepository.save(gist);
    }
}
