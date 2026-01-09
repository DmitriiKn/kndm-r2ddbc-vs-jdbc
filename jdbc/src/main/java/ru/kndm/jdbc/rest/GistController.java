package ru.kndm.jdbc.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kndm.jdbc.peristence.entity.Gist;
import ru.kndm.jdbc.peristence.repository.GistRepository;

import java.util.List;

@RestController
@RequestMapping("api/v1/gists")
@RequiredArgsConstructor
@Slf4j
public class GistController {

    private final GistRepository gistRepository;

    @GetMapping
    public List<Gist> getAllGists() {
        log.debug("Processing request on thread: {}", Thread.currentThread().getName());
        return gistRepository.findAll();
    }

    @GetMapping("/{id}")
    public Gist getGist(@PathVariable Long id) {
        return gistRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Gist createGist(@RequestBody Gist gist) {
        return gistRepository.save(gist);
    }
}
