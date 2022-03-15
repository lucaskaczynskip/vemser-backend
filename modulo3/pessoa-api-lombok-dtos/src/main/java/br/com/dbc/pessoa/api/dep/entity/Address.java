package br.com.dbc.pessoa.api.dep.entity;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Address {

    private Integer idAddress;
    private Integer idPerson;
    private String type;
    private String address;
    private String number;
    private String cep;
    private String city;
    private String state;
    private String country;
}
