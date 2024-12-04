package br.com.payment.consumer;

import br.com.payment.dto.Mensagem;
import br.com.payment.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
    private PagamentoService service;

    @Autowired
    public Consumer(PagamentoService service) {
        this.service = service;
    }

    @KafkaListener(topics = "pedido.order", groupId = "group-1")
    public void consumer(Mensagem message){
        System.out.println(message.numeroOrdem());

        service.processarPagamento(message);
    }
}
