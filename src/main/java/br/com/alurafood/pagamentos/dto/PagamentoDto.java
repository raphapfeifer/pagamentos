package br.com.alurafood.pagamentos.dto;

import br.com.alurafood.pagamentos.enums.StatusEnum;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PagamentoDto {


    private Long id;
    private BigDecimal valor;
    private String nome;
    private String numero;
    private String expirado;
    private String codigo;
    //private StatusEnum status;
    private Long pedidoId;
    private Long formaDePagamento;
}
