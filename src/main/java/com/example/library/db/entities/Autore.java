package com.example.library.db.entities;

import com.example.library.db.dtos.AutoreDto;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"nome", "cognome"}))
public class Autore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cognome;
    private LocalDate dataNascita;

    public Autore(AutoreDto autoreDto) {
        this.nome = autoreDto.getNome();
        this.cognome = autoreDto.getCognome();
        this.dataNascita = autoreDto.getDataNascita();
    }
}