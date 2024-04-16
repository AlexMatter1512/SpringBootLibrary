package com.example.library.db.repositories;

import com.example.library.db.entities.Autore;
import com.example.library.db.entities.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepo extends JpaRepository<Libro, Long> {

    Libro findByTitoloAndAutore_NomeAndAutore_Cognome(String titolo, String nome, String cognome);
}
