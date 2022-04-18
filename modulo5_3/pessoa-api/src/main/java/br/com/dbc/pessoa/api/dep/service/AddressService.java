package br.com.dbc.pessoa.api.dep.service;

import br.com.dbc.pessoa.api.dep.dto.AddressCreateDTO;
import br.com.dbc.pessoa.api.dep.dto.AddressDTO;
import br.com.dbc.pessoa.api.dep.entity.AddressEntity;
import br.com.dbc.pessoa.api.dep.exception.BusinessRuleException;
import br.com.dbc.pessoa.api.dep.repository.AddressRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log
public class AddressService {

    @Autowired
    private AddressRepository repo;

    @Autowired
    private ObjectMapper objectMapper;

    public List<AddressDTO> get() {
        return repo.findAll()
                .stream()
                .map(a -> objectMapper.convertValue(a, AddressDTO.class))
                .collect(Collectors.toList());
    }

    public AddressDTO get(Integer id) throws BusinessRuleException {
        AddressEntity address = repo.getById(id);
        return objectMapper.convertValue(address, AddressDTO.class);
    }

    public AddressDTO add(AddressCreateDTO a) throws BusinessRuleException {
        AddressEntity address = objectMapper.convertValue(a, AddressEntity.class);
        AddressEntity created = repo.save(address);
        return objectMapper.convertValue(created, AddressDTO.class);
    }

    public AddressDTO update(Integer id, AddressCreateDTO a) throws BusinessRuleException {
        AddressEntity address = objectMapper.convertValue(a, AddressEntity.class);

        AddressEntity exists = repo.findById(id).get();

        exists.setType(a.getType());
        exists.setAddress(a.getAddress());
        exists.setNumber(a.getNumber());
        exists.setComplement(a.getComplement());
        exists.setCep(a.getCep());
        exists.setCity(a.getCity());
        exists.setState(a.getState());
        exists.setCountry(a.getCountry());

        AddressEntity updated = repo.save(exists);
        return objectMapper.convertValue(updated, AddressDTO.class);
    }

    public AddressDTO remove(Integer id) throws BusinessRuleException {
        AddressEntity address = repo.findById(id).get();
        repo.delete(address);
        return objectMapper.convertValue(address, AddressDTO.class);
    }
}
