package br.com.dbc.pessoa.api.dep.repository;

import br.com.dbc.pessoa.api.dep.entity.PersonEntity;
import br.com.dbc.pessoa.api.dep.exception.BusinessRuleException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {

    List<PersonEntity> findByNameStartingWithIgnoreCase(String str);
    PersonEntity findByCpf(String cpf);
    List<PersonEntity> findByDateBetween(LocalDate init, LocalDate end);
}
