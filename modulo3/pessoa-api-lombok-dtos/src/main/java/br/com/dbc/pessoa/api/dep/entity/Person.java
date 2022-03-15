package br.com.dbc.pessoa.api.dep.entity;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Person {

    private Integer idPerson;
    private String name;
    private String email;
    private String cpf;
    private LocalDate date;
}
