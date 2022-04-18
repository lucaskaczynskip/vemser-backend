package br.com.dbc.pessoa.api.dep.dto;

import br.com.dbc.pessoa.api.dep.entity.AddressType;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class AddressCreateDTO {

    @NotNull
    private AddressType type;

    @NotEmpty
    @Size(max = 250)
    private String address;

    @NotNull
    private Integer number;

    @NotEmpty
    private String complement;

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
