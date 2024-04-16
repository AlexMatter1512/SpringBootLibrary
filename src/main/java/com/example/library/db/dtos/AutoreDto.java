package com.example.library.db.dtos;

import com.example.library.db.entities.Autore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutoreDto {
    private String nome;
    private String cognome;
    private LocalDate dataNascita;

    public AutoreDto(Autore autore) {
        this.nome = autore.getNome();
        this.cognome = autore.getCognome();
        this.dataNascita = autore.getDataNascita();
    }
}
