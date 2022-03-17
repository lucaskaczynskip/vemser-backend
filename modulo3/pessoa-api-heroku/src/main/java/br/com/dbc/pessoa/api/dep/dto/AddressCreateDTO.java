package br.com.dbc.pessoa.api.dep.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class AddressCreateDTO {

    private Integer idPerson;

    @NotEmpty
    private String type;

    @NotEmpty
    @Size(max = 250)
    private String address;

    @NotEmpty
    private String number;

    @NotEmpty
    @Size(max = 8)
    private String cep;

    @NotEmpty
    @Size(max = 250)
    private String city;

    @NotEmpty
    private String state;

    @NotEmpty
    private String country;
}
