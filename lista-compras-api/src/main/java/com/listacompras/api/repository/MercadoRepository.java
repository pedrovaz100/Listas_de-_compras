package com.listacompras.api.repository;

import com.listacompras.api.model.Mercado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MercadoRepository extends JpaRepository<Mercado, Long> {
}