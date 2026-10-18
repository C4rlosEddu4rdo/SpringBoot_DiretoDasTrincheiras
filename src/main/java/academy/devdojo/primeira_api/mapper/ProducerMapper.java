package academy.devdojo.primeira_api.mapper;

import academy.devdojo.primeira_api.domain.Producer;
import academy.devdojo.primeira_api.dto.request.ProducerPostRequest;
import academy.devdojo.primeira_api.dto.request.ProducerPutRequest;
import academy.devdojo.primeira_api.dto.response.ProducerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring")
public interface ProducerMapper {

    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    Producer toProducer(ProducerPostRequest postRequest);
    Producer toProducer(ProducerPutRequest  putRequest, LocalDateTime createdAt);
    ProducerResponse  toProducerResponse(Producer producer);

}
