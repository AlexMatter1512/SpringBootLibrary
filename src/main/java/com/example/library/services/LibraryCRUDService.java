package com.example.library.services;

import com.example.library.db.dtos.LibroDto;
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

    public Libro aggiungiLibro(LibroDto libroDto) {
        Autore autoreDto = libroDto.getAutore();

        //se il libro esiste
        Libro existingLibro = LibroRepo.findByTitoloAndAutore_NomeAndAutore_Cognome(libroDto.getTitolo(), autoreDto.getNome(), autoreDto.getCognome());
        if (existingLibro != null) {
            existingLibro.setCopieTotali(existingLibro.getCopieTotali() + 1);
            existingLibro.setCopieDisponibili(existingLibro.getCopieDisponibili() + 1);
            return LibroRepo.save(existingLibro);
        }

        //se il libro non esiste ma l'autore si
        Autore existingAutore = AutoreRepo.findByNomeAndCognomeAndDataNascita(autoreDto.getNome(), autoreDto.getCognome(), autoreDto.getDataNascita());
        if (existingAutore != null) {
            Libro libro = new Libro();
            libro.setTitolo(libroDto.getTitolo());
            libro.setAnnoProduzione(libroDto.getAnnoProduzione());
            libro.setCopieTotali(1);
            libro.setCopieDisponibili(1);
            libro.setAutore(existingAutore);

            return LibroRepo.save(libro);
        }

        //se il libro e l'autore non esistono
        Libro libro = new Libro();
        libro.setTitolo(libroDto.getTitolo());
        libro.setAnnoProduzione(libroDto.getAnnoProduzione());
        libro.setCopieTotali(1);
        libro.setCopieDisponibili(1);
        libro.setAutore(libroDto.getAutore());

        return LibroRepo.save(libro);
    }

    public void rimuoviLibro(Long id) {
        LibroRepo.deleteById(id);
    }

    public Optional<Libro> getLibroById(Long id) {
        return LibroRepo.findById(id);
    }

    public List<Autore> getAllAutori() {
        return AutoreRepo.findAll();
    }

    public Autore aggiungiAutore(Autore autore) {
        return AutoreRepo.save(autore);
    }

    // Altre operazioni sui libri e sugli autori...
}
