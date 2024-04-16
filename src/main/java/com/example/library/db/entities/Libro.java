package com.example.library.db.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titolo;
    private int annoProduzione;

    //variabili non richieste dal test
    private int copieDisponibili;
    private int copieTotali;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Autore autore;
}