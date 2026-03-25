package com.listacompras.api.repository;

import com.listacompras.api.model.ListaCompra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListaCompraRepository extends JpaRepository<ListaCompra, Long> {
}
