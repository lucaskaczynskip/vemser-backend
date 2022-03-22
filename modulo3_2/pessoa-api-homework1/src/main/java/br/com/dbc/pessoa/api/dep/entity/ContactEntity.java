package br.com.dbc.pessoa.api.dep.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity(name = "CONTATO")
public class ContactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTATO_SEQ")
    @SequenceGenerator(name = "CONTATO_SEQ", sequenceName = "seq_pessoa2", allocationSize = 1)
    @Column(name = "id_contato")
    private Integer idContact;

    @Column(name = "id_pessoa")
    private Integer idPerson;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "tipo")
    private ContactType type;

    @Column(name = "numero")
    private String number;

    @Column(name = "descricao")
    private String description;
}
