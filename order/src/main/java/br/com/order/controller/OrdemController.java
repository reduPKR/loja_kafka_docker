package br.com.order.controller;

import br.com.order.dto.OrdemRequest;
import br.com.order.dto.OrdemResponse;
import br.com.order.entity.Ordem;
import br.com.order.mapper.OrdemMapper;
import br.com.order.service.OrdemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ordem")
public class OrdemController {
    private final OrdemService service;

    @Autowired
    public OrdemController(OrdemService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<OrdemResponse> salvar(@Validated @RequestBody OrdemRequest request){
        Ordem ordem = OrdemMapper.INSTANCE.requestToModel(request);
        System.out.println("teste");
        service.salvar(ordem);

        OrdemResponse response = OrdemMapper.INSTANCE.modelToResponse(ordem);

        if (response.id() != 0){
            return new ResponseEntity<OrdemResponse>(response, HttpStatus.CREATED);
        }
        return new ResponseEntity<OrdemResponse>(response, HttpStatus.BAD_REQUEST);
    }
}
