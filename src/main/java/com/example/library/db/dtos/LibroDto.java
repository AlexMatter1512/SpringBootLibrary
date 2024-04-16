package com.example.library.db.dtos;

import com.example.library.db.entities.Autore;
import lombok.Data;

@Data
public class LibroDto {
    private String titolo;
    private int annoProduzione;

    private String nomeAutore;
    private String cognomeAutore;
    private String dataNascitaAutore;
}
