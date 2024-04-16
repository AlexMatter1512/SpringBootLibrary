package com.example.library.services;

import com.example.library.db.dtos.LibroDto;
import com.example.library.db.entities.Autore;
import com.example.library.db.entities.Libro;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.library.db.repositories.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {
    private final LibroRepo LibroRepo;
    private final AutoreRepo AutoreRepo;

    public LibraryService(LibroRepo LibroRepo, AutoreRepo AutoreRepo) {
        this.LibroRepo = LibroRepo;
        this.AutoreRepo = AutoreRepo;
    }

    public ResponseEntity<LibroDto> reserveLibroById(Long id) {
        Optional<Libro> libro = LibroRepo.findById(id);
        if (libro.isPresent()) {
            if (libro.get().getCopieDisponibili() > 0) {
                libro.get().setCopieDisponibili(libro.get().getCopieDisponibili() - 1);
                LibroRepo.save(libro.get());
                LibroDto libroDto = new LibroDto(libro.get());
                return ResponseEntity.ok(libroDto);
            } else {
                return ResponseEntity.badRequest().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<LibroDto> returnLibroById(Long id) {
        Optional<Libro> libro = LibroRepo.findById(id);
        if (libro.isPresent()) {
            if (libro.get().getCopieDisponibili() < libro.get().getCopieTotali()) {
                libro.get().setCopieDisponibili(libro.get().getCopieDisponibili() + 1);
                LibroRepo.save(libro.get());
                LibroDto libroDto = new LibroDto(libro.get());
                return ResponseEntity.ok(libroDto);
            } else {
                return ResponseEntity.badRequest().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    public List<LibroDto> getAllLibri() {
        List<Libro> libri = LibroRepo.findAll();
        List<LibroDto> libriDto = new ArrayList<>();
        for (Libro libro : libri) {
            LibroDto libroDto = new LibroDto(libro);
            libriDto.add(libroDto);
        }
        return libriDto;
    }

}