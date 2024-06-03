package br.com.alurafood.pagamentos.model;

import br.com.alurafood.pagamentos.enums.StatusEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

@Entity
@Table(name="PAGAMENTOS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Positive
    @Column(name = "VALOR")
    private BigDecimal valor;

    @NotBlank
    @Size(max=100)
    @Column(name = "NOME")
    private String nome;

    @NotBlank
    @Size(max=19)
    @Column(name = "NUMERO")
    private String numero;

    @NotBlank
    @Size(max=7)
    @Column(name = "EXPIRADO")
    private String expirado;

    @NotBlank
    @Size(min=3, max=3)
    @Column(name = "CODIGO")
    private String codigo;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private StatusEnum status;

    @NotNull
    @Column(name = "PEDIDO_ID")
    private Long pedidoId;

    @NotNull
    @Column(name = "FORMA_PAGAMENTO")
    private Long formaDePagamento;

}
