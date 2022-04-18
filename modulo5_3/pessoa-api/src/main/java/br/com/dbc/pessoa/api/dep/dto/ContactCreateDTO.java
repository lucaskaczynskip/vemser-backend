package br.com.dbc.pessoa.api.dep.dto;

import br.com.dbc.pessoa.api.dep.entity.ContactType;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ContactCreateDTO {

    private Integer idPerson;

    @NotNull
    private ContactType type;

    @NotEmpty
    @Size(max = 13)
    private String number;

    @NotEmpty
    private String description;
}
