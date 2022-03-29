package br.com.dbc.pessoa.api.dep.entity;

import br.com.dbc.pessoa.api.dep.entity.pk.ProfessorPK;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name="professor")
public class TeacherEntity {

    @EmbeddedId
    private ProfessorPK professorPK;

    @Column(name = "nome")
    private String name;

    @Column(name = "salario")
    private Double salary;
}
