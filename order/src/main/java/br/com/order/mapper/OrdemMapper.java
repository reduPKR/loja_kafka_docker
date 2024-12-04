package br.com.order.mapper;

import br.com.order.dto.Mensagem;
import br.com.order.dto.OrdemRequest;
import br.com.order.dto.OrdemResponse;
import br.com.order.entity.Ordem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrdemMapper {
    OrdemMapper INSTANCE = Mappers.getMapper(OrdemMapper.class);

    Ordem requestToModel(OrdemRequest request);

    OrdemResponse modelToResponse(Ordem model);

    Mensagem modelToMessage(Ordem ordem);
}
