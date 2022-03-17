package br.com.dbc.pessoa.api.dep.controller;

import br.com.dbc.pessoa.api.dep.dto.PersonCreateDTO;
import br.com.dbc.pessoa.api.dep.dto.PersonDTO;
import br.com.dbc.pessoa.api.dep.entity.Person;
import br.com.dbc.pessoa.api.dep.exception.BusinessRuleException;
import br.com.dbc.pessoa.api.dep.exception.CustomGlobalExceptionHandler;
import br.com.dbc.pessoa.api.dep.service.EmailService;
import br.com.dbc.pessoa.api.dep.service.PersonService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    @Autowired
    private EmailService mailService;

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
        return service.get(str);
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

        StringBuilder message = new StringBuilder();
        message.append("Estamos felizes em ter você no nosso sistema :)\n");
        message.append("Seu cadastro foi realizado com sucesso, seu identificador é " + created.getIdPerson());

        mailService.sendEmail(message.toString(), "Bem vindo ao sistema de Pessoas", "Olá " + created.getName(), created.getEmail());

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

        StringBuilder message = new StringBuilder();
        message.append("Seus dados foram atualizados no sistema.\n");

        mailService.sendEmail(message.toString(), "Atualização de dados", "Olá " + updated.getName(), updated.getEmail());

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

        StringBuilder message = new StringBuilder();
        message.append("Você perdeu acesso ao nosso sistema.\n");

        mailService.sendEmail(message.toString(), "Perda de acesso", "Olá " + removed.getName(), removed.getEmail());

        return ResponseEntity.ok(removed);
    }
}
