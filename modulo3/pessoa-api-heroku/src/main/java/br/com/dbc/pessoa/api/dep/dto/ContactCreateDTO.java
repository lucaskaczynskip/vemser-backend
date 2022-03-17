package br.com.dbc.pessoa.api.dep.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class ContactCreateDTO {

    private Integer idPerson;

    @NotEmpty
    private String type;

    @NotEmpty
    @Size(max = 13)
    private String number;

    @NotEmpty
    private String description;
}
