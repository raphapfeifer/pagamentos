package br.com.alurafood.pagamentos.dao;

import br.com.alurafood.pagamentos.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoDao extends JpaRepository<Pagamento,Long> {
    
}
