package br.com.dbc.pessoa.api.dep.repository;

import br.com.dbc.pessoa.api.dep.entity.Adress;
import br.com.dbc.pessoa.api.dep.entity.Person;
import br.com.dbc.pessoa.api.dep.exception.BusinessRuleException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AddressRepository {

    private List<Adress> list = new ArrayList<>();
    private AtomicInteger c = new AtomicInteger();

    public AddressRepository() {
        list.add(new Adress(
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

    public List<Adress> getAll() {
        return list;
    }

    public Adress getById(Integer id) throws BusinessRuleException {
        return list.stream()
                .filter(address -> address.getIdAddress().equals(id))
                .findFirst()
                .orElseThrow(() -> new BusinessRuleException("Endereço não encontrado"));
    }

    public List<Adress> getByPerson(Integer id) {
        return list.stream()
                .filter(a -> a.getIdPerson().equals(id))
                .toList();
    }

    public Adress create(Integer id, Adress a) throws BusinessRuleException {
        Person exists = new PersonRepository(true).getById(id);
        a.setIdAddress(c.incrementAndGet());
        a.setIdPerson(exists.getIdPerson());
        list.add(a);
        return a;
    }

    public Adress update(Integer id, Adress a) throws BusinessRuleException {
        Adress exists = this.getById(id);

        a.setIdAddress(exists.getIdAddress());
        a.setIdPerson(exists.getIdPerson());

        list.add(list.indexOf(exists), a);
        list.remove(exists);

        return a;
    }

    public Adress delete(Integer id) throws BusinessRuleException {
        Adress a = this.getById(id);
        list.remove(a);
        return a;
    }
}
