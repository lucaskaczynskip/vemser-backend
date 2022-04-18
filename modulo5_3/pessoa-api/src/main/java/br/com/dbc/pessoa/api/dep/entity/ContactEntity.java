package br.com.dbc.pessoa.api.dep.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(name = "id_pessoa", insertable = false, updatable = false)
    private Integer idPerson;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "tipo")
    private ContactType type;

    @Column(name = "numero")
    private String number;

    @Column(name = "descricao")
    private String description;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id_pessoa")
    private PersonEntity personEntity;
}
