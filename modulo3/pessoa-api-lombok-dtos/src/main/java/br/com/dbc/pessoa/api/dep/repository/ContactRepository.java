package br.com.dbc.pessoa.api.dep.repository;

import br.com.dbc.pessoa.api.dep.entity.Contact;
import br.com.dbc.pessoa.api.dep.entity.Person;
import br.com.dbc.pessoa.api.dep.exception.BusinessRuleException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@org.springframework.stereotype.Repository
public class ContactRepository implements Repository<Integer, Contact> {

    private List<Contact> list = new ArrayList<>();
    private AtomicInteger c = new AtomicInteger();

    public ContactRepository() {
        list.add(new Contact(c.incrementAndGet(), 1, "residencial", "996829690", "whatsapp"));
    }


    @Override
    public List<Contact> getAll() {
        return list;
    }

    @Override
    public Contact getById(Integer id) throws BusinessRuleException {
        return list.stream()
                .filter(c -> c.getIdContact().equals(id))
                .findFirst()
                .orElseThrow(() -> new BusinessRuleException("Contato não encontrado."));
    }

    @Override
    public Contact create(Contact object) throws BusinessRuleException {
        return null;
    }

    public List<Contact>    getByPerson(Integer id) throws BusinessRuleException {
        return list.stream()
                .filter(c -> c.getIdPerson().equals(id))
                .toList();
    }

    public Contact create(Integer id, Contact object) throws BusinessRuleException {
        Person exists = new PersonRepository(true).getById(id);
        object.setIdContact(c.incrementAndGet());
        object.setIdPerson(id);
        list.add(object);
        return object;
    }

    @Override
    public Contact update(Integer id, Contact object) throws BusinessRuleException {
        Contact exists = this.getById(id);

        object.setIdContact(exists.getIdContact());
        object.setIdPerson(exists.getIdPerson());

        list.add(list.indexOf(exists), object);
        list.remove(exists);

        return object;
    }

    @Override
    public Contact delete(Integer id) throws BusinessRuleException {
        Contact contact = this.getById(id);
        list.remove(contact);
        return contact;
    }
}
