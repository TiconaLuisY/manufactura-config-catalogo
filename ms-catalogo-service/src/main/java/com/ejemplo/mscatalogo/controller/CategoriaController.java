package com.ejemplo.mscatalogo.controller;

import com.ejemplo.mscatalogo.entity.Categoria;
import com.ejemplo.mscatalogo.service.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> listar() {
        return ResponseEntity.ok(categoriaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscar(@PathVariable Integer id) {
        return categoriaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Categoria> guardar(@RequestBody Categoria categoria) {
        Categoria guardada = categoriaService.guardar(categoria);
        return ResponseEntity.created(URI.create("/categoria/" + guardada.getId())).body(guardada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> actualizar(@PathVariable Integer id, @RequestBody Categoria categoria) {
        return categoriaService.actualizar(id, categoria)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        return categoriaService.eliminar(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
