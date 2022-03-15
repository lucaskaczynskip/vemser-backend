package br.com.dbc.pessoa.api.dep.service;

import br.com.dbc.pessoa.api.dep.entity.Adress;
import br.com.dbc.pessoa.api.dep.exception.BusinessRuleException;
import br.com.dbc.pessoa.api.dep.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository repo;

    public List<Adress> get() {
        return repo.getAll();
    }

    public Adress get(Integer id) throws BusinessRuleException {
        return repo.getById(id);
    }

    public List<Adress> getByPerson(Integer id) {
        return repo.getByPerson(id);
    }

    public Adress add(Integer id, Adress a) throws BusinessRuleException {
        return repo.create(id, a);
    }

    public Adress update(Integer id, Adress a) throws BusinessRuleException {
        return repo.update(id, a);
    }

    public Adress remove(Integer id) throws BusinessRuleException {
        return repo.delete(id);
    }
}
