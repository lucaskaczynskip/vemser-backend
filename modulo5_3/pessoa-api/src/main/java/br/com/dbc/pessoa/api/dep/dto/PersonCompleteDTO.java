package br.com.dbc.pessoa.api.dep.dto;

import lombok.Data;

import java.util.List;

@Data
public class PersonCompleteDTO extends PersonCreateDTO {

    private Integer idPerson;
    private List<AddressDTO> addresses;
    private List<ContactDTO> contacts;
}
