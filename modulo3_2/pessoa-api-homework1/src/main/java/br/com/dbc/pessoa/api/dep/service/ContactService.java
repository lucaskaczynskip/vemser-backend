package br.com.dbc.pessoa.api.dep.service;

import br.com.dbc.pessoa.api.dep.dto.ContactCreateDTO;
import br.com.dbc.pessoa.api.dep.dto.ContactDTO;
import br.com.dbc.pessoa.api.dep.entity.ContactEntity;
import br.com.dbc.pessoa.api.dep.entity.ContactType;
import br.com.dbc.pessoa.api.dep.entity.PersonEntity;
import br.com.dbc.pessoa.api.dep.exception.BusinessRuleException;
import br.com.dbc.pessoa.api.dep.repository.ContactRepository;
import br.com.dbc.pessoa.api.dep.repository.PersonRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository repo;
    private final PersonRepository personRepository;
    private final ObjectMapper objectMapper;

    public List<ContactDTO> get() {
        return repo.findAll()
                .stream()
                .map(c -> objectMapper.convertValue(c, ContactDTO.class))
                .collect(Collectors.toList());
    }

    public ContactDTO get(Integer id) throws BusinessRuleException {
        ContactEntity contact = repo.findById(id).get();
        return objectMapper.convertValue(contact, ContactDTO.class);
    }

    public List<ContactDTO> getByPerson(Integer id) throws BusinessRuleException {
        return repo.findByIdPerson(id)
                .stream()
                .map(c -> objectMapper.convertValue(c, ContactDTO.class))
                .collect(Collectors.toList());
    }

    public ContactDTO add(Integer id, ContactCreateDTO object) throws BusinessRuleException {
        PersonEntity person = personRepository.findById(id).get();

        ContactDTO contact = objectMapper.convertValue(object, ContactDTO.class);
        ContactEntity entity = objectMapper.convertValue(contact, ContactEntity.class);
        ContactEntity created = repo.save(entity);
        return objectMapper.convertValue(created, ContactDTO.class);
    }

    public ContactDTO update(Integer id, ContactCreateDTO object) throws BusinessRuleException {
        ContactDTO contact = objectMapper.convertValue(object, ContactDTO.class);
        ContactEntity exists = repo.findById(id).get();

        exists.setType(contact.getType());
        exists.setDescription(contact.getDescription());
        exists.setNumber(contact.getNumber());

        ContactEntity updated = repo.save(exists);
        return objectMapper.convertValue(updated, ContactDTO.class);
    }

    public ContactDTO remove(Integer id) throws BusinessRuleException {
        ContactEntity contact = repo.findById(id).get();
        repo.delete(contact);
        return objectMapper.convertValue(contact, ContactDTO.class);
    }
}
