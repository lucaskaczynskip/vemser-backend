package br.com.dbc.pessoa.api.dep.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Contact {

    private Integer idContact;
    private Integer idPerson;
    private String type;
    private String number;
    private String description;
}
