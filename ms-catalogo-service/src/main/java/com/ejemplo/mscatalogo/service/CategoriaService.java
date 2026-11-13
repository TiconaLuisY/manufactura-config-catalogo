package com.ejemplo.mscatalogo.service;

import com.ejemplo.mscatalogo.entity.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {
    List<Categoria> listar();
    Optional<Categoria> buscarPorId(Integer id);
    Categoria guardar(Categoria categoria);
    Optional<Categoria> actualizar(Integer id, Categoria categoria);
    boolean eliminar(Integer id);
}

