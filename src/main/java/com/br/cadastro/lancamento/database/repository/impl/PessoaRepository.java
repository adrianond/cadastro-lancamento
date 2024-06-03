package com.br.cadastro.lancamento.database.repository.impl;


import com.br.cadastro.lancamento.database.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
