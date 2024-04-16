package com.example.library.controllers;

import com.example.library.db.dtos.LibroDto;
import com.example.library.db.entities.Libro;
import com.example.library.db.entities.Autore;
import com.example.library.services.LibraryCRUDService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/biblioteca")
public class LibraryCrudController {
    private final LibraryCRUDService LibraryCRUDService;

    public LibraryCrudController(LibraryCRUDService LibraryCRUDService) {
        this.LibraryCRUDService = LibraryCRUDService;
    }

    @GetMapping("/libri")
    public List<Libro> getAllLibri() {
        return LibraryCRUDService.getAllLibri();
    }

    @PostMapping("/libri")
    public Libro aggiungiLibro(@RequestBody LibroDto libroDto) {
        return LibraryCRUDService.aggiungiLibro(libroDto);
    }

    @DeleteMapping("/libri/{id}")
    public void rimuoviLibro(@PathVariable Long id) {
        LibraryCRUDService.rimuoviLibro(id);
    }

    @GetMapping("/libri/{id}")
    public ResponseEntity<Libro> getLibroById(@PathVariable Long id) {
        Optional<Libro> libro = LibraryCRUDService.getLibroById(id);
        return libro.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/autori")
    public List<Autore> getAllAutori() {
        return LibraryCRUDService.getAllAutori();
    }

    @PostMapping("/autori")
    public Autore aggiungiAutore(@RequestBody Autore autore) {
        return LibraryCRUDService.aggiungiAutore(autore);
    }

}

