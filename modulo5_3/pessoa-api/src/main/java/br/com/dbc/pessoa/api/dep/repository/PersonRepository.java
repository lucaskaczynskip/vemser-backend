package br.com.dbc.pessoa.api.dep.repository;

import br.com.dbc.pessoa.api.dep.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {

    List<PersonEntity> findByNameStartingWithIgnoreCase(String str);
    PersonEntity findByCpf(String cpf);
    List<PersonEntity> findByDateBetween(LocalDate init, LocalDate end);

    @Query("select p from PESSOA p inner join fetch p.addresses")
    List<PersonEntity> findPersonWhereAddressExists();

    @Query("select p from PESSOA p WHERE p.date BETWEEN :end AND :init")
    List<PersonEntity> findByLocalDateBetween(LocalDate init, LocalDate end);

    @Query(value = "SELECT * FROM PESSOA p LEFT JOIN PESSOA_X_PESSOA_ENDERECO ep ON p.id_pessoa = ep.id_pessoa WHERE ep.id_pessoa IS NULL", nativeQuery = true)
    List<PersonEntity> findPersonWhereNoContact();
    
    @Query(nativeQuery = true, value = "SELECT "
            + "        * "
            + "    FROM "
            + "        PESSOA p "
            + "    LEFT JOIN"
            + "        PESSOA_X_PESSOA_ENDERECO e "
            + "            ON e.ID_PESSOA = p.ID_PESSOA "
            + "    WHERE"
            + "        e.ID_PESSOA IS NULL")
    List<PersonEntity> findPersonNoAddresses();
    
    @Query(nativeQuery = true, value = "SELECT * FROM PESSOA p"
    		+ "    WHERE extract(month from data_nascimento) = extract(month from sysdate)"
    		+ "          AND extract(day from data_nascimento) = extract(day from sysdate)")
    List<PersonEntity> findPersonAniverario();
    
}   
    
