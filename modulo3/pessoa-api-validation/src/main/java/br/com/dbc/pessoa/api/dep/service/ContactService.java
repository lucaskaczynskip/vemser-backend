package br.com.dbc.pessoa.api.dep.service;

import br.com.dbc.pessoa.api.dep.entity.Contact;
import br.com.dbc.pessoa.api.dep.entity.Person;
import br.com.dbc.pessoa.api.dep.exception.BusinessRuleException;
import br.com.dbc.pessoa.api.dep.repository.ContactRepository;
import br.com.dbc.pessoa.api.dep.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class ContactService implements Service<Integer, Contact> {

    @Autowired
    private ContactRepository repo;

    @Override
    public List<Contact> get() {
        return repo.getAll();
    }

    @Override
    public Contact get(Integer id) throws BusinessRuleException {
        return repo.getById(id);
    }

    @Override
    public Contact add(Contact object) throws BusinessRuleException {
        return null;
    }

    public List<Contact> getByPerson(Integer id) throws BusinessRuleException {
        return repo.getByPerson(id);
    }

    public Contact add(Integer id, Contact object) throws BusinessRuleException {
//        Person person = new PersonRepository().getById(object.getIdPerson());
        return repo.create(id, object);
    }

    @Override
    public Contact update(Integer id, Contact object) throws BusinessRuleException {
        return repo.update(id, object);
    }

    @Override
    public Contact remove(Integer id) throws BusinessRuleException {
        return repo.delete(id);
    }
}
