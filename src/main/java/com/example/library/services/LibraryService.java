package com.example.library.services;

import com.example.library.db.entities.Autore;
import com.example.library.db.entities.Libro;
import org.springframework.stereotype.Service;
import com.example.library.db.repositories.*;

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

    public List<Libro> reserveLibroById() {
        return LibroRepo.findAll();
    }

}