package br.com.dbc.pessoa.api.dep.service;

import br.com.dbc.pessoa.api.dep.dto.PersonCreateDTO;
import br.com.dbc.pessoa.api.dep.dto.PersonDTO;
import br.com.dbc.pessoa.api.dep.entity.PersonEntity;
import br.com.dbc.pessoa.api.dep.exception.BusinessRuleException;
import br.com.dbc.pessoa.api.dep.repository.PersonRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

//    public List<PersonDTO> get(String str) {
//        return repo.getByName(str)
//                .stream()
//                .map(p -> objectMapper.convertValue(p, PersonDTO.class))
//                .collect(Collectors.toList());
//    }

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
}
