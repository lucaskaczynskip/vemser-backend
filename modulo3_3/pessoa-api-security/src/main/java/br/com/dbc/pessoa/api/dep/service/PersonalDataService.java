package br.com.dbc.pessoa.api.dep.service;

import br.com.dbc.pessoa.api.dep.dto.DadosPessoaisDTO;
import br.com.dbc.pessoa.api.dep.extern.IPersonalData;
import feign.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalDataService {

    @Autowired
    private IPersonalData personalData;

    public List<DadosPessoaisDTO> get() {
        return personalData.getAll();
    }

    public DadosPessoaisDTO get(String cpf) {
        return personalData.get(cpf);
    }

    public DadosPessoaisDTO post(DadosPessoaisDTO dadosPessoaisDTO) {
        return personalData.post(dadosPessoaisDTO);
    }

    public DadosPessoaisDTO put(String cpf, DadosPessoaisDTO dadosPessoaisDTO) {
        return personalData.put(cpf, dadosPessoaisDTO);
    }

    public void delete(String cpf) {
        personalData.delete(cpf);
    }
}
