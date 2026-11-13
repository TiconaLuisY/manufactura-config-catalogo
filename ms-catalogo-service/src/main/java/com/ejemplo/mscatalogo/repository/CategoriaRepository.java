package com.ejemplo.mscatalogo.repository;

import com.ejemplo.mscatalogo.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}

