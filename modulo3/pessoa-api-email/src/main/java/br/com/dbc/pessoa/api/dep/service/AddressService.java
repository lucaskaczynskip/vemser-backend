package br.com.dbc.pessoa.api.dep.service;

import br.com.dbc.pessoa.api.dep.dto.AddressCreateDTO;
import br.com.dbc.pessoa.api.dep.dto.AddressDTO;
import br.com.dbc.pessoa.api.dep.entity.Address;
import br.com.dbc.pessoa.api.dep.exception.BusinessRuleException;
import br.com.dbc.pessoa.api.dep.repository.AddressRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log
public class AddressService {

    @Autowired
    private AddressRepository repo;

    @Autowired
    private ObjectMapper objectMapper;

    public List<AddressDTO> get() {
        return repo.getAll()
                .stream()
                .map(a -> objectMapper.convertValue(a, AddressDTO.class))
                .toList();
    }

    public AddressDTO get(Integer id) throws BusinessRuleException {
        Address address = repo.getById(id);
        return objectMapper.convertValue(address, AddressDTO.class);
    }

    public List<AddressDTO> getByPerson(Integer id) {
        return repo.getByPerson(id)
                .stream()
                .map(a -> objectMapper.convertValue(a, AddressDTO.class))
                .toList();
    }

    public AddressDTO add(Integer id, AddressCreateDTO a) throws BusinessRuleException {
        Address address = objectMapper.convertValue(a, Address.class);
        Address created = repo.create(id, address);
        return objectMapper.convertValue(created, AddressDTO.class);
    }

    public AddressDTO update(Integer id, AddressCreateDTO a) throws BusinessRuleException {
        Address address = objectMapper.convertValue(a, Address.class);
        Address updated = repo.update(id, address);
        return objectMapper.convertValue(updated, AddressDTO.class);
    }

    public AddressDTO remove(Integer id) throws BusinessRuleException {
        Address address = repo.delete(id);
        return objectMapper.convertValue(address, AddressDTO.class);
    }
}
