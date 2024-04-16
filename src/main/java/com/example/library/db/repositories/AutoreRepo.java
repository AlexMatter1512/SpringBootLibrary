package com.example.library.db.repositories;

import com.example.library.db.entities.Autore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoreRepo extends JpaRepository<Autore, Long> {
}
