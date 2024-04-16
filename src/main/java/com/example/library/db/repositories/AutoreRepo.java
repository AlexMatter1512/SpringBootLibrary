package com.example.library.db.repositories;

import com.example.library.db.entities.Autore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface AutoreRepo extends JpaRepository<Autore, Long> {
    Autore findByNomeAndCognomeAndDataNascita(String nome, String cognome, LocalDate dataNascita);

}
