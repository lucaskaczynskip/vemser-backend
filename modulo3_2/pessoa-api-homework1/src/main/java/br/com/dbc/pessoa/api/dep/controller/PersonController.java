package br.com.dbc.pessoa.api.dep.controller;

import br.com.dbc.pessoa.api.dep.dto.*;
import br.com.dbc.pessoa.api.dep.entity.PersonEntity;
import br.com.dbc.pessoa.api.dep.exception.BusinessRuleException;
import br.com.dbc.pessoa.api.dep.repository.PersonRepository;
import br.com.dbc.pessoa.api.dep.service.EmailService;
import br.com.dbc.pessoa.api.dep.service.PersonService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PersonController {

    @Autowired
    private PersonService service;

    @Autowired
    private EmailService mailService;

    @Autowired
    private PersonRepository personRepository;

    @ApiOperation(value = "Retorna uma lista de pessoas")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de pessoas")
    })
    @GetMapping
    public List<PersonDTO> get() {
        return service.get();
    }

    @ApiOperation(value = "Retorna uma pessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a pessoa pelo id"),
            @ApiResponse(code = 500, message = "Gera uma exceção se a pessoa não existir")
    })
    @GetMapping("/{idPerson}")
    public ResponseEntity<PersonDTO> get(@PathVariable("idPerson") Integer id) throws BusinessRuleException {
        PersonDTO person = service.get(id);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @ApiOperation(value = "Retorna uma lista de pessoas")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma lista de pessoas pelo nome"),
    })
    @GetMapping("/byname")
    public List<PersonDTO> get(@RequestParam("nome") String str) {
        return service.getByName(str);
    }

    @GetMapping("/bycpf")
    public PersonDTO getByCpf(@RequestParam("cpf") String str) {
        return service.getByCpf(str);
    }

    @GetMapping("/date")
    public List<PersonDTO> getByDateBetween(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate init,
                                            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        return service.getByDateBetween(init, end);
    }

    @ApiOperation(value = "Cria uma pessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Cria e retorna a pessoa criada"),
            @ApiResponse(code = 500, message = "Gera uma exceçâo")
    })
    @PostMapping
    @Validated
    public ResponseEntity<PersonDTO> add(@Valid @RequestBody PersonCreateDTO person) throws BusinessRuleException {
        PersonDTO created = service.add(person);
        return ResponseEntity.ok(created);
    }

    @ApiOperation(value = "Atualiza uma pessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Atualiza a pessoa pelo id"),
            @ApiResponse(code = 500, message = "Gera uma exceção se a pessoa não existir")
    })
    @PutMapping("/{idPerson}")
    @Validated
    public ResponseEntity<PersonDTO> update(@PathVariable("idPerson") Integer id,
                         @Valid @RequestBody PersonCreateDTO person) throws BusinessRuleException {
        PersonDTO updated = service.update(id, person);
        return ResponseEntity.ok(updated);
    }

    @ApiOperation(value = "Deleta uma pessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Deleta a pessoa pelo id"),
            @ApiResponse(code = 500, message = "Gera uma exceção se a pessoa não existir")
    })
    @DeleteMapping("/{idPerson}")
    @Validated
    public ResponseEntity<PersonDTO> remove(@Valid @PathVariable("idPerson") Integer id) throws BusinessRuleException {
        PersonDTO removed = service.remove(id);
        return ResponseEntity.ok(removed);
    }

    @GetMapping("/list-with-contacts")
    public List<PersonWithContactsDTO> getWithContacts(@RequestParam(value = "id", required = false) Integer id) throws BusinessRuleException {
        return service.getWithContact(id);
    }

    @GetMapping("/list-with-addresses")
    public List<PersonWithAddressesDTO> getWithAddresses(@RequestParam(value = "id", required = false) Integer id) throws BusinessRuleException {
        return service.getWithAddresses(id);
    }

    @GetMapping("/where-exists-addresses")
    public List<PersonEntity> findPersonWhereAddressExists() {
        return personRepository.findPersonWhereAddressExists();
    }

    @GetMapping("/where-date")
    public List<PersonEntity> findByLocalDateBetween(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate init,
                                                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        return personRepository.findByLocalDateBetween(init, end);
    }

    @GetMapping("/person-complete")
    public List<PersonCompleteDTO> getCompletePerson(@RequestParam(value = "id", required = false) Integer id) throws BusinessRuleException {
        return service.getCompletePerson(id);
    }

    @GetMapping("/person-it-does-not-have-address")
    public List<PersonEntity> findPersonWhereNoContact() {
        return personRepository.findPersonWhereNoContact();
    }
}
