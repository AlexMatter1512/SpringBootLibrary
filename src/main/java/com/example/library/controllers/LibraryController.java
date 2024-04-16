package com.example.library.controllers;

import com.example.library.db.dtos.LibroDto;
import com.example.library.db.entities.Libro;
import com.example.library.services.LibraryCRUDService;
import com.example.library.services.LibraryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class LibraryController {
    private final LibraryService LibraryService;
    private final LibraryCRUDService LibraryCRUDService;

    public LibraryController(LibraryService LibraryService, LibraryCRUDService LibraryCRUDService) {
        this.LibraryService = LibraryService;
        this.LibraryCRUDService = LibraryCRUDService;
    }

    @GetMapping("/list")
    public List<LibroDto> getAllLibri() {
        return LibraryService.getAllLibri();
    }

    @GetMapping("/reserve")
    public ResponseEntity<LibroDto> reserveLibroById(@RequestParam Long id) {
        return LibraryService.reserveLibroById(id);
    }

    @GetMapping("/return")
    public ResponseEntity<LibroDto> returnLibroById(@RequestParam Long id) {
        return LibraryService.returnLibroById(id);
    }
}
