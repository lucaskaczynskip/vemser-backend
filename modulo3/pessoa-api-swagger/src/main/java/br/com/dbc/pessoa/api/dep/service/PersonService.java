package br.com.dbc.pessoa.api.dep.service;

import br.com.dbc.pessoa.api.dep.dto.PersonCreateDTO;
import br.com.dbc.pessoa.api.dep.dto.PersonDTO;
import br.com.dbc.pessoa.api.dep.entity.Person;
import br.com.dbc.pessoa.api.dep.exception.BusinessRuleException;
import br.com.dbc.pessoa.api.dep.repository.PersonRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repo;

    @Autowired
    private ObjectMapper objectMapper;

    public List<PersonDTO> get() {
        return repo.getAll()
                .stream()
                .map(p -> objectMapper.convertValue(p, PersonDTO.class))
                .toList();
    }


    public PersonDTO get(Integer id) throws BusinessRuleException {
        Person person = repo.getById(id);
        return objectMapper.convertValue(person, PersonDTO.class);
    }

    public List<PersonDTO> get(String str) {
        return repo.getByName(str)
                .stream()
                .map(p -> objectMapper.convertValue(p, PersonDTO.class))
                .toList();
    }

    public PersonDTO add(PersonCreateDTO object) throws BusinessRuleException {
        boolean exists = repo.getAll().stream()
                .anyMatch(person -> person.getEmail().equalsIgnoreCase(object.getEmail()) || person.getCpf().equalsIgnoreCase(object.getCpf()));

        if (exists) {
            throw new BusinessRuleException("Usuário já cadastrado.");
        }

        Person person = objectMapper.convertValue(object, Person.class);
        Person created = repo.create(person);

        return objectMapper.convertValue(created, PersonDTO.class);
    }

    public PersonDTO update(Integer id, PersonCreateDTO object) throws BusinessRuleException {
        Person person = objectMapper.convertValue(object, Person.class);
        Person updated = repo.update(id, person);

        return objectMapper.convertValue(updated, PersonDTO.class);
    }

    public PersonDTO remove(Integer id) throws BusinessRuleException {
        Person p = repo.delete(id);
        return objectMapper.convertValue(p, PersonDTO.class);
    }
}
