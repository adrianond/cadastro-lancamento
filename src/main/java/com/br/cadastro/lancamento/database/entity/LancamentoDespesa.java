package com.br.cadastro.lancamento.database.entity;


import com.br.cadastro.lancamento.database.entity.enumeration.TipoLancamento;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@EqualsAndHashCode(of = "id")
@Data
@Table(name = "lancamento_despesa")
@NoArgsConstructor
public class LancamentoDespesa implements Serializable {

    @Id
    @SequenceGenerator(name = "SEQ_LANCAMENTO_DESPESA", sequenceName = "SEQ_LANCAMENTO_DESPESA", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_LANCAMENTO_DESPESA")
    private Long id;

    private String descricao;

    @Column(name = "data_lancamento")
    private LocalDate dataLancamento;

    @Column(name = "valor", scale = 2)
    private BigDecimal valor;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "tipo_lancamento")
    private TipoLancamento tipoLancamento;
    private String observacao;

    private String responsavel;

    @JoinColumn(name = "id_categoria", referencedColumnName = "id", nullable = false)
    @ManyToOne(targetEntity = Categoria.class, fetch = FetchType.LAZY)
    private Categoria categoria;


}
