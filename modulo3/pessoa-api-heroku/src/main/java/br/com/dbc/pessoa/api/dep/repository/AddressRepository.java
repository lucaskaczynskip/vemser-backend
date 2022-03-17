package br.com.dbc.pessoa.api.dep.repository;

import br.com.dbc.pessoa.api.dep.entity.Address;
import br.com.dbc.pessoa.api.dep.entity.Person;
import br.com.dbc.pessoa.api.dep.exception.BusinessRuleException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AddressRepository {

    private List<Address> list = new ArrayList<>();
    private AtomicInteger c = new AtomicInteger();

    public AddressRepository() {
        list.add(new Address(
                c.incrementAndGet(),
                1,
                "residencial",
                "Av. Mauricio Cardoso",
                "2187",
                "96700000",
                "São Jerônimo",
                "RS",
                "Brasil"
                ));
    }

    public List<Address> getAll() {
        return list;
    }

    public Address getById(Integer id) throws BusinessRuleException {
        return list.stream()
                .filter(address -> address.getIdAddress().equals(id))
                .findFirst()
                .orElseThrow(() -> new BusinessRuleException("Endereço não encontrado"));
    }

    public List<Address> getByPerson(Integer id) {
        return list.stream()
                .filter(a -> a.getIdPerson().equals(id))
                .toList();
    }

    public Address create(Integer id, Address a) throws BusinessRuleException {
        Person exists = new PersonRepository(true).getById(id);
        a.setIdAddress(c.incrementAndGet());
        a.setIdPerson(exists.getIdPerson());
        list.add(a);
        return a;
    }

    public Address update(Integer id, Address a) throws BusinessRuleException {
        Address exists = this.getById(id);

        a.setIdAddress(exists.getIdAddress());
        a.setIdPerson(exists.getIdPerson());

        list.add(list.indexOf(exists), a);
        list.remove(exists);

        return a;
    }

    public Address delete(Integer id) throws BusinessRuleException {
        Address a = this.getById(id);
        list.remove(a);
        return a;
    }
}
