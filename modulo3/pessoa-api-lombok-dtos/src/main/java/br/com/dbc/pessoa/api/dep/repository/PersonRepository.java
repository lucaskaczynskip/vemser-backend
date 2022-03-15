package br.com.dbc.pessoa.api.dep.repository;

import br.com.dbc.pessoa.api.dep.entity.Person;
import br.com.dbc.pessoa.api.dep.exception.BusinessRuleException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@org.springframework.stereotype.Repository
public class PersonRepository implements Repository<Integer, Person> {

    private static List<Person> list = new ArrayList<>();
    private static AtomicInteger c = new AtomicInteger();

    public PersonRepository() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        list.add(new Person(c.incrementAndGet(), "Lucas", "lucaskp@email.com", "05410816080", LocalDate.parse("10/10/1990", formatter)));
    }

    public PersonRepository(boolean isEmpty) {}

    @Override
    public List<Person> getAll() {
        return list;
    }

    @Override
    public Person getById(Integer id) throws BusinessRuleException {
        Person person = list.stream()
                .filter(p -> p.getIdPerson().equals(id))
                .findFirst()
                .orElseThrow(() -> new BusinessRuleException("Usuário não encontrado"));

        return person;
    }

    public List<Person> getByName(String str) {
        List<Person> persons = list.stream()
                .filter(person -> person.getName().toLowerCase().contains(str.toLowerCase()))
                .toList();
        return persons;
    }

    @Override
    public Person create(Person object) throws BusinessRuleException {
        object.setIdPerson(c.incrementAndGet());
        list.add(object);
        return object;
    }

    @Override
    public Person update(Integer id, Person object) throws BusinessRuleException {
        Person person = this.getById(id);

        object.setIdPerson(person.getIdPerson());

        list.add(list.indexOf(person), object);
        list.remove(person);

        return object;
    }

    @Override
    public Person delete(Integer id) throws BusinessRuleException {
        Person person = this.getById(id);
        list.remove(person);
        return person;
    }
}
