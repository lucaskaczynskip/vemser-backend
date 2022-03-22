package br.com.dbc.pessoa.api.dep.dto;

import lombok.*;

import java.util.List;

@Data
public class PersonWithContactsDTO extends PersonCreateDTO {

    private Integer idPerson;
    private List<ContactDTO> contacts;
}
