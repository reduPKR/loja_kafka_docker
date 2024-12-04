package br.com.order.service;

import br.com.order.dto.Mensagem;
import br.com.order.entity.Ordem;
import br.com.order.mapper.OrdemMapper;
import br.com.order.repositories.OrdemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrdemService {
    private final OrdemRepository repository;
    private KafkaTemplate<String, Mensagem> kafkaTemplate;

    @Autowired
    public OrdemService(OrdemRepository repository, KafkaTemplate<String, Mensagem> kafkaTemplate) {
        this.repository = repository;
        this.kafkaTemplate = kafkaTemplate;
    }


    public void salvar(Ordem ordem) {
        ordem.setConcluido(true);
        repository.save(ordem);

        Mensagem mensagem = OrdemMapper.INSTANCE.modelToMessage(ordem);

        kafkaTemplate.send("pedido.ordem", mensagem);
    }
}
