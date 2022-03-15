package br.com.dbc.pessoa.api.dep.controller;

import br.com.dbc.pessoa.api.dep.dto.PersonCreateDTO;
import br.com.dbc.pessoa.api.dep.dto.PersonDTO;
import br.com.dbc.pessoa.api.dep.entity.Person;
import br.com.dbc.pessoa.api.dep.exception.BusinessRuleException;
import br.com.dbc.pessoa.api.dep.exception.CustomGlobalExceptionHandler;
import br.com.dbc.pessoa.api.dep.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping
    public List<PersonDTO> get() {
        return service.get();
    }

    // TODO - criar classe para mostrar erro
    @GetMapping("/{idPerson}")
    public ResponseEntity<PersonDTO> get(@PathVariable("idPerson") Integer id) throws BusinessRuleException {
        PersonDTO person = service.get(id);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @GetMapping("/byname")
    public List<PersonDTO> get(@RequestParam("nome") String str) {
        return service.get(str);
    }

    @PostMapping
    @Validated
    public ResponseEntity<PersonDTO> add(@Valid @RequestBody PersonCreateDTO person) throws BusinessRuleException {
        return ResponseEntity.ok(service.add(person));
    }

    @PutMapping("/{idPerson}")
    @Validated
    public ResponseEntity<PersonDTO> update(@PathVariable("idPerson") Integer id,
                         @Valid @RequestBody PersonCreateDTO person) throws BusinessRuleException {
        return ResponseEntity.ok(service.update(id, person));
    }

    @DeleteMapping("/{idPerson}")
    @Validated
    public ResponseEntity<PersonDTO> remove(@Valid @PathVariable("idPerson") Integer id) throws BusinessRuleException {
        return ResponseEntity.ok(service.remove(id));
    }
}
