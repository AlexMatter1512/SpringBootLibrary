package com.example.library.db.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titolo;
    private int annoProduzione;

    //variabili non richieste dal test
    private int copieDisponibili;
    private int copieTotali;

    @ManyToOne(cascade = CascadeType.ALL)
    private Autore autore;

}