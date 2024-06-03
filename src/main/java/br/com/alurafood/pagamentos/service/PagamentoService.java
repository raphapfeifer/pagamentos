package br.com.alurafood.pagamentos.service;


import br.com.alurafood.pagamentos.dao.PagamentoDao;
import br.com.alurafood.pagamentos.dto.PagamentoDto;
import br.com.alurafood.pagamentos.enums.StatusEnum;
import br.com.alurafood.pagamentos.model.Pagamento;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
public class PagamentoService {

    @Autowired
    private PagamentoDao dao;

    @Autowired
    private ModelMapper modelMapper;

    public Page<PagamentoDto> obterTodos(Pageable paginacao){
        return  dao.findAll(paginacao)
                .map(p -> modelMapper.map(p, PagamentoDto.class));
    }

    public PagamentoDto obterPorId(Long id){
        Pagamento pagamento = dao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());

        return modelMapper.map(pagamento,PagamentoDto.class);
    }

    public PagamentoDto criarPagamento(PagamentoDto pagamentoDto){
        Pagamento pagamento = modelMapper.map(pagamentoDto, Pagamento.class);
        pagamento.setStatus(StatusEnum.CRIADO);
        dao.save(pagamento);

        return modelMapper.map(pagamento,PagamentoDto.class);
    }

    public PagamentoDto atualizarPagamento(Long id, @Valid PagamentoDto pagamentoDto){
        Pagamento pagamento = modelMapper.map(pagamentoDto, Pagamento.class);
        pagamento.setId(id);
        pagamento = dao.save(pagamento);
        return modelMapper.map(pagamento, PagamentoDto.class);
    }

    public void excluirPagamento(Long id){
        dao.deleteById(id);
    }

}
