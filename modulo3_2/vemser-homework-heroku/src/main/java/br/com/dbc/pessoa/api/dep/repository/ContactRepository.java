package br.com.dbc.pessoa.api.dep.repository;

import br.com.dbc.pessoa.api.dep.entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, Integer> {
    List<ContactEntity> findByIdPerson(Integer id);
}
