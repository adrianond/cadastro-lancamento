package com.br.cadastro.lancamento.database.repository.impl;


import com.br.cadastro.lancamento.database.entity.LancamentoDespesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LancamentoDespesaRepository extends JpaRepository<LancamentoDespesa, Long> {

}
