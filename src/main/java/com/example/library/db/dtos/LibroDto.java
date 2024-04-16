package com.example.library.db.dtos;

import com.example.library.db.entities.Autore;
import com.example.library.db.entities.Libro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibroDto {
    private String titolo;
    private int annoProduzione;

    private AutoreDto autore;

    public LibroDto(Libro libro) {
        this.titolo = libro.getTitolo();
        this.annoProduzione = libro.getAnnoProduzione();
        this.autore = new AutoreDto(libro.getAutore());
    }
}
