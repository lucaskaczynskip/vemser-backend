package br.com.dbc.pessoa.api.dep.repository;

import br.com.dbc.pessoa.api.dep.entity.ContactEntity;
import br.com.dbc.pessoa.api.dep.entity.ContactType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, Integer> {
    List<ContactEntity> findByIdPerson(Integer id);

    @Query("SELECT c FROM CONTATO c WHERE c.type = :type")
    List<ContactEntity> findByContactType(ContactType type);

    @Query(value = "SELECT * FROM CONTATO c WHERE c.id_pessoa = :id", nativeQuery = true)
    List<ContactEntity> findContactByPersonId(Integer id);
}
