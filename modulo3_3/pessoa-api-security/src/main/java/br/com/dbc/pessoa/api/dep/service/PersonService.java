package br.com.dbc.pessoa.api.dep.service;

import br.com.dbc.pessoa.api.dep.dto.*;
import br.com.dbc.pessoa.api.dep.entity.PersonEntity;
import br.com.dbc.pessoa.api.dep.exception.BusinessRuleException;
import br.com.dbc.pessoa.api.dep.repository.PersonRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository repo;
    private final ObjectMapper objectMapper;

    public List<PersonDTO> get() {
        return repo.findAll()
                .stream()
                .map(p -> objectMapper.convertValue(p, PersonDTO.class))
                .collect(Collectors.toList());
    }

    public PersonDTO get(Integer id) throws BusinessRuleException {
        PersonEntity personEntity = repo.findById(id)
                .orElseThrow(() -> new BusinessRuleException("Pessoa não encontrada"));
        return objectMapper.convertValue(personEntity, PersonDTO.class);
    }

    public PersonDTO add(PersonCreateDTO object) throws BusinessRuleException {
        boolean exists = repo.findAll().stream()
                .anyMatch(person -> person.getEmail().equalsIgnoreCase(object.getEmail()) || person.getCpf().equalsIgnoreCase(object.getCpf()));

        if (exists) {
            throw new BusinessRuleException("Usuário já cadastrado.");
        }

        PersonEntity personEntity = objectMapper.convertValue(object, PersonEntity.class);
        PersonEntity created = repo.save(personEntity);

        return objectMapper.convertValue(created, PersonDTO.class);
    }

    public PersonDTO update(Integer id, PersonCreateDTO object) throws BusinessRuleException {
        PersonEntity personEntity = objectMapper.convertValue(object, PersonEntity.class);
        PersonEntity exists = repo.findById(id).get();

        exists.setCpf(personEntity.getCpf());
        exists.setDate(personEntity.getDate());
        exists.setEmail(personEntity.getEmail());
        exists.setName(personEntity.getName());

        PersonEntity updated = repo.save(exists);

        return objectMapper.convertValue(updated, PersonDTO.class);
    }

    public PersonDTO remove(Integer id) throws BusinessRuleException {
        PersonEntity exists = repo.findById(id).get();
        repo.deleteById(id);
        return objectMapper.convertValue(exists, PersonDTO.class);
    }

    public List<PersonDTO> getByName(String str) {
        return repo.findByNameStartingWithIgnoreCase(str)
                .stream()
                .map(p -> objectMapper.convertValue(p, PersonDTO.class))
                .collect(Collectors.toList());
    }

    public PersonDTO getByCpf(String cpf) {
        PersonEntity person = repo.findByCpf(cpf);
        return objectMapper.convertValue(person, PersonDTO.class);
    }

    public List<PersonDTO> getByDateBetween(LocalDate init, LocalDate end) {
        return repo.findByDateBetween(init, end)
                .stream()
                .map(personEntity -> objectMapper.convertValue(personEntity, PersonDTO.class))
                .collect(Collectors.toList());
    }

    public List<PersonWithContactsDTO> getWithContact(Integer id) throws BusinessRuleException {
        if (id == null) {
            return repo.findAll().stream()
                    .map(person -> {
                        PersonWithContactsDTO personDTO = objectMapper.convertValue(person, PersonWithContactsDTO.class);
                        personDTO.setContacts(person.getContacts().stream()
                                .map(contact -> objectMapper.convertValue(contact, ContactDTO.class))
                                .collect(Collectors.toList())
                        );

                        return personDTO;
                    })
                    .collect(Collectors.toList());
        }

        PersonEntity person = repo.findById(id)
                .orElseThrow(() -> new BusinessRuleException("Pessoa não econtrada."));
        PersonWithContactsDTO personDTO = objectMapper.convertValue(person, PersonWithContactsDTO.class);
        personDTO.setContacts(person.getContacts().stream()
                .map(contact -> objectMapper.convertValue(contact, ContactDTO.class))
                .collect(Collectors.toList()));

        return List.of(personDTO);
    }

    public List<PersonWithAddressesDTO> getWithAddresses(Integer id) throws BusinessRuleException {
        if (id == null) {
            return repo.findAll().stream()
                    .map(person -> {
                        PersonWithAddressesDTO personDTO = objectMapper.convertValue(person, PersonWithAddressesDTO.class);
                        personDTO.setAddresses(person.getAddresses().stream()
                                .map(address -> objectMapper.convertValue(address, AddressDTO.class))
                                .collect(Collectors.toList()));
                        return personDTO;
                    })
                    .collect(Collectors.toList());
        }

        PersonEntity person = repo.findById(id)
                .orElseThrow(() -> new BusinessRuleException("Pessoa não econtrada."));
        PersonWithAddressesDTO personDTO = objectMapper.convertValue(person, PersonWithAddressesDTO.class);
        personDTO.setAddresses(person.getAddresses().stream()
                .map(address -> objectMapper.convertValue(address, AddressDTO.class))
                .collect(Collectors.toList()));

        return List.of(personDTO);
    }

    public List<PersonCompleteDTO> getCompletePerson(Integer id) throws BusinessRuleException {
        if (id == null) {
            return repo.findAll().stream()
                    .map(personEntity -> {
                        PersonCompleteDTO personDTO = objectMapper.convertValue(personEntity, PersonCompleteDTO.class);
                        personDTO.setAddresses(personEntity.getAddresses().stream()
                                .map(address -> objectMapper.convertValue(address, AddressDTO.class))
                                .collect(Collectors.toList()));
                        personDTO.setContacts(personEntity.getContacts().stream()
                                .map(contact -> objectMapper.convertValue(contact, ContactDTO.class))
                                .collect(Collectors.toList()));
                        return personDTO;
                    })
                    .collect(Collectors.toList());
        }

        return repo.findById(id).stream()
                .map(personEntity -> {
                    PersonCompleteDTO personDTO = objectMapper.convertValue(personEntity, PersonCompleteDTO.class);
                    personDTO.setAddresses(personEntity.getAddresses().stream()
                            .map(address -> objectMapper.convertValue(address, AddressDTO.class))
                            .collect(Collectors.toList()));
                    personDTO.setContacts(personEntity.getContacts().stream()
                            .map(contact -> objectMapper.convertValue(contact, ContactDTO.class))
                            .collect(Collectors.toList()));
                    return personDTO;
                })
                .collect(Collectors.toList());
    }
}
