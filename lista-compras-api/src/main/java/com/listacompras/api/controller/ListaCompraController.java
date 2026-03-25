package com.listacompras.api.controller;

import com.listacompras.api.model.ListaCompra;
import com.listacompras.api.repository.ListaCompraRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/listas")
public class ListaCompraController {

    private final ListaCompraRepository repository;

    public ListaCompraController(ListaCompraRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<ListaCompra> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ListaCompra buscar(@PathVariable Long id) {
        return buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ListaCompra criar(@RequestBody ListaCompra listaCompra) {
        return repository.save(listaCompra);
    }

    @PutMapping("/{id}")
    public ListaCompra atualizar(@PathVariable Long id, @RequestBody ListaCompra listaCompra) {
        ListaCompra existente = buscarPorId(id);
        BeanUtils.copyProperties(listaCompra, existente, "id");
        return repository.save(existente);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        ListaCompra existente = buscarPorId(id);
        repository.delete(existente);
    }

    private ListaCompra buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Lista de compra não encontrada"));
    }
}
