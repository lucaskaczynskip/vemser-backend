package br.com.dbc.pessoa.api.dep.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity(name = "ENDERECO_PESSOA")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENDERECO_PESSOA_SEQ")
    @SequenceGenerator(name = "ENDERECO_PESSOA_SEQ", sequenceName = "seq_endereco_contato", allocationSize = 1)
    @Column(name = "id_endereco")
    private Integer idAddress;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "tipo")
    private AddressType type;

    @Column(name = "logradouro")
    private String address;

    @Column(name = "numero")
    private Integer number;

    @Column(name = "complemento")
    private String complement;

    @Column(name = "cep")
    private String cep;

    @Column(name = "cidade")
    private String city;

    @Column(name = "estado")
    private String state;

    @Column(name = "pais")
    private String country;

    @JsonIgnore
    @ManyToMany(mappedBy = "addresses")
    private Set<PersonEntity> persons;
}
