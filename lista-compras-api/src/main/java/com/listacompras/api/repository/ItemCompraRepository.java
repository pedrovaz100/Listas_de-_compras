package com.listacompras.api.repository;

import com.listacompras.api.model.ItemCompra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemCompraRepository extends JpaRepository<ItemCompra, Long> {
}
