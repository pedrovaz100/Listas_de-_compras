package com.listacompras.api.controller;

import com.listacompras.api.model.ItemCompra;
import com.listacompras.api.repository.ItemCompraRepository;
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
@RequestMapping("/itens")
public class ItemCompraController {


    private final ItemCompraRepository repository;

    public ItemCompraController(ItemCompraRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<ItemCompra> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ItemCompra buscar(@PathVariable Long id) {
        return buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ItemCompra criar(@RequestBody ItemCompra itemCompra) {
        return repository.save(itemCompra);
    }

    @PutMapping("/{id}")
    public ItemCompra atualizar(@PathVariable Long id, @RequestBody ItemCompra itemCompra) {
        ItemCompra existente = buscarPorId(id);
        BeanUtils.copyProperties(itemCompra, existente, "id");
        return repository.save(existente);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        ItemCompra existente = buscarPorId(id);
        repository.delete(existente);
    }

    private ItemCompra buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item de compra não encontrado"));
    }
}
