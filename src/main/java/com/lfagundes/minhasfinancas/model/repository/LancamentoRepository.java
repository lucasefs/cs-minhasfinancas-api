package com.lfagundes.minhasfinancas.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lfagundes.minhasfinancas.model.entity.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{

}
