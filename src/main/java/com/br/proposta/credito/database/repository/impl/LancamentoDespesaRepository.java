package com.br.proposta.credito.database.repository.impl;


import com.br.proposta.credito.database.entity.LancamentoDespesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LancamentoDespesaRepository extends JpaRepository<LancamentoDespesa, Long> {

}
