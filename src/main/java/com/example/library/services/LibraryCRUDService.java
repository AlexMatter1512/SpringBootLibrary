package com.example.library.services;

import com.example.library.db.entities.Autore;
import com.example.library.db.entities.Libro;
import org.springframework.stereotype.Service;
import com.example.library.db.repositories.*;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryCRUDService {
    private final LibroRepo LibroRepo;
    private final AutoreRepo AutoreRepo;

    public LibraryCRUDService(LibroRepo LibroRepo, AutoreRepo AutoreRepo) {
        this.LibroRepo = LibroRepo;
        this.AutoreRepo = AutoreRepo;
    }

    public List<Libro> getAllLibri() {
        return LibroRepo.findAll();
    }

    public Libro aggiungiLibro(Libro libro) {
        return LibroRepo.save(libro);
    }

    public void rimuoviLibro(Long id) {
        LibroRepo.deleteById(id);
    }

    public Optional<Libro> getLibroById(Long id) {
        return LibroRepo.findById(id);
    }

    public Libro modificaLibro(Long id, Libro nuovoLibro) {
        nuovoLibro.setId(id);
        return LibroRepo.save(nuovoLibro);
    }

    public List<Autore> getAllAutori() {
        return AutoreRepo.findAll();
    }

    public Autore aggiungiAutore(Autore autore) {
        return AutoreRepo.save(autore);
    }

    // Altre operazioni sui libri e sugli autori...
}
