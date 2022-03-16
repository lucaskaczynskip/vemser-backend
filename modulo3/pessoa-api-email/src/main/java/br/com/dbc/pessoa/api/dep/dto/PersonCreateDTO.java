package br.com.dbc.pessoa.api.dep.dto;

import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
public class PersonCreateDTO {

    @NotEmpty
    private String name;

    @NotEmpty
    @Email
    private String email;

    @NotNull
    @CPF
    @Size(max = 11)
    private String cpf;

    @NotNull
    @Past
    private LocalDate date;
}
