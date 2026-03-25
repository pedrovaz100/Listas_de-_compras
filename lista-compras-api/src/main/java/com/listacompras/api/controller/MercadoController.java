package com.listacompras.api.controller;

import com.listacompras.api.model.Mercado;
import com.listacompras.api.repository.MercadoRepository;
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
@RequestMapping("/mercados")
public class MercadoController {

    private final MercadoRepository repository;

    public MercadoController(MercadoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Mercado> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Mercado buscar(@PathVariable Long id) {
        return buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mercado criar(@RequestBody Mercado mercado) {
        return repository.save(mercado);
    }

    @PutMapping("/{id}")
    public Mercado atualizar(@PathVariable Long id, @RequestBody Mercado mercado) {
        Mercado existente = buscarPorId(id);
        BeanUtils.copyProperties(mercado, existente, "id");
        return repository.save(existente);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        Mercado existente = buscarPorId(id);
        repository.delete(existente);
    }

    private Mercado buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mercado não encontrado"));
    }
}