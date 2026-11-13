package com.ejemplo.mscatalogo.service.impl;

import com.ejemplo.mscatalogo.entity.Categoria;
import com.ejemplo.mscatalogo.repository.CategoriaRepository;
import com.ejemplo.mscatalogo.service.CategoriaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public List<Categoria> listar() {
        return categoriaRepository.findAll();
    }

    @Override
    public Optional<Categoria> buscarPorId(Integer id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public Categoria guardar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Optional<Categoria> actualizar(Integer id, Categoria datos) {
        return categoriaRepository.findById(id).map(categoria -> {
            categoria.setNombre(datos.getNombre());
            return categoriaRepository.save(categoria);
        });
    }

    @Override
    public boolean eliminar(Integer id) {
        if (!categoriaRepository.existsById(id)) {
            return false;
        }
        categoriaRepository.deleteById(id);
        return true;
    }
}

