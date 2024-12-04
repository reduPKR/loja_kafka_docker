package br.com.payment.service;

import br.com.payment.dto.Mensagem;
import br.com.payment.entity.Pagamento;
import br.com.payment.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {
    private final PagamentoRepository repository;

    @Autowired
    public PagamentoService(PagamentoRepository repository) {
        this.repository = repository;
    }

    public void processarPagamento(Mensagem message) {
        if (message.numeroOrdem().contains("a")){
            Pagamento pagamento = new Pagamento();
            pagamento.setNumeroPagamento("111111");
            pagamento.setNumeroOrdem(message.numeroOrdem());
            pagamento.setConcluido(true);

            repository.save(pagamento);

            System.out.println("Mandar para o proximo");
        }else {
            System.out.println("Vai iniciar o saga pattern");
        }
    }
}
