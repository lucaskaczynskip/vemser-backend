package br.com.dbc.pessoa.api.dep.extern;

import br.com.dbc.pessoa.api.dep.dto.DadosPessoaisDTO;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

@FeignClient(value="dados-pessoais-api", url="https://my-application-teste.herokuapp.com")
@Headers("Content-Type: application/json")
public interface IPersonalData {

    @RequestLine("GET /dados-pessoais")
    List<DadosPessoaisDTO> getAll();

    @RequestLine("POST /dados-pessoais")
    DadosPessoaisDTO post(DadosPessoaisDTO dadosPessoaisDTO);

    @RequestLine("PUT /dados-pessoais/{cpf}")
    DadosPessoaisDTO put(@Param("cpf") String cpf, DadosPessoaisDTO dadosPessoaisDTO);

    @RequestLine("DELETE /dados-pessoais/{cpf}")
    void delete(@Param("cpf") String cpf);

    @RequestLine("GET /dados-pessoais/{cpf}")
    DadosPessoaisDTO get(@Param("cpf") String cpf);
}
