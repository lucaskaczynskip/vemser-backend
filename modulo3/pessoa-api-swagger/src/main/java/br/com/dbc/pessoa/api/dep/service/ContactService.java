package br.com.dbc.pessoa.api.dep.service;

import br.com.dbc.pessoa.api.dep.dto.ContactCreateDTO;
import br.com.dbc.pessoa.api.dep.dto.ContactDTO;
import br.com.dbc.pessoa.api.dep.entity.Contact;
import br.com.dbc.pessoa.api.dep.exception.BusinessRuleException;
import br.com.dbc.pessoa.api.dep.repository.ContactRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository repo;

    @Autowired
    private ObjectMapper objectMapper;


    public List<ContactDTO> get() {
        return repo.getAll()
                .stream()
                .map(c -> objectMapper.convertValue(c, ContactDTO.class))
                .toList();
    }

    public ContactDTO get(Integer id) throws BusinessRuleException {
        Contact contact = repo.getById(id);
        return objectMapper.convertValue(contact, ContactDTO.class);
    }

    public List<ContactDTO> getByPerson(Integer id) throws BusinessRuleException {
        return repo.getByPerson(id)
                .stream()
                .map(c -> objectMapper.convertValue(c, ContactDTO.class))
                .toList();
    }

    public ContactDTO add(Integer id, ContactCreateDTO object) throws BusinessRuleException {
        Contact contact = objectMapper.convertValue(object, Contact.class);
        Contact created = repo.create(id, contact);
        return objectMapper.convertValue(created, ContactDTO.class);
    }

    public ContactDTO update(Integer id, ContactCreateDTO object) throws BusinessRuleException {
        Contact contatc = objectMapper.convertValue(object, Contact.class);
        Contact updated = repo.update(id, contatc);
        return objectMapper.convertValue(updated, ContactDTO.class);
    }

    public ContactDTO remove(Integer id) throws BusinessRuleException {
        Contact contact = repo.delete(id);
        return objectMapper.convertValue(contact, ContactDTO.class);
    }
}
