package br.com.dbc.pessoa.api.dep.repository;

import br.com.dbc.pessoa.api.dep.entity.TeacherEntity;
import br.com.dbc.pessoa.api.dep.entity.pk.ProfessorPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherEntity, ProfessorPK> {
}
