package br.com.dbc.pessoa.api.dep.service;

import br.com.dbc.pessoa.api.dep.entity.Person;
import br.com.dbc.pessoa.api.dep.exception.BusinessRuleException;
import br.com.dbc.pessoa.api.dep.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class PersonService implements Service<Integer, Person> {

    @Autowired
    private PersonRepository repo;

    @Override
    public List<Person> get() {
        return repo.getAll();
    }

    @Override
    public Person get(Integer id) throws BusinessRuleException {
        return repo.getById(id);
    }

    public List<Person> get(String str) {
        return repo.getByName(str);
    }

    @Override
    public Person add(Person object) throws BusinessRuleException {
        boolean exists = repo.getAll().stream()
                .anyMatch(person -> person.getEmail().equalsIgnoreCase(object.getEmail()) || person.getCpf().equalsIgnoreCase(object.getCpf()));

        if (exists) {
            throw new BusinessRuleException("Usuário já cadastrado.");
        }

        Person person = repo.create(object);
        return person;
    }

    @Override
    public Person update(Integer id, Person object) throws BusinessRuleException {
        return repo.update(id, object);
    }

    @Override
    public Person remove(Integer id) throws BusinessRuleException {
        return repo.delete(id);
    }
}
