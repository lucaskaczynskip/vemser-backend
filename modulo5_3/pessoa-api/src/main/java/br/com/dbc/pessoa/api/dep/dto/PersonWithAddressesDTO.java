package br.com.dbc.pessoa.api.dep.dto;

import lombok.Data;

import java.util.List;

@Data
public class PersonWithAddressesDTO extends PersonCreateDTO {

    private Integer idPerson;
    private List<AddressDTO> addresses;
}
