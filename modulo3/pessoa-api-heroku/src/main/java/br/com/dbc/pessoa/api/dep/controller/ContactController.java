package br.com.dbc.pessoa.api.dep.controller;

import br.com.dbc.pessoa.api.dep.dto.ContactDTO;
import br.com.dbc.pessoa.api.dep.dto.ContactCreateDTO;
import br.com.dbc.pessoa.api.dep.entity.Contact;
import br.com.dbc.pessoa.api.dep.exception.BusinessRuleException;
import br.com.dbc.pessoa.api.dep.service.ContactService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contato")
public class ContactController {

    @Autowired
    private ContactService service;

    @ApiOperation(value = "Recebe uma lista de contatos")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Recebe uma lista com todos os contatos")
    })
    @GetMapping
    public List<ContactDTO> get() {
        return service.get();
    }

    @ApiOperation(value = "Recebe um contato")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Busca um contato pelo seu id"),
            @ApiResponse(code = 500, message = "Não encontra o contato")
    })
    @GetMapping("/{idContact}")
    public ContactDTO get(@PathVariable("idContact") Integer id) throws BusinessRuleException {
        return service.get(id);
    }

    @ApiOperation(value = "Recebe uma lista de contatos de uma pessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Recebe uma lista de contatos pelo id de uma pessoa"),
            @ApiResponse(code = 500, message = "Não encontra a pessoa")
    })
    @GetMapping("/{idPerson}/pessoa")
    public List<ContactDTO> getByPerson(@PathVariable("idPerson") Integer id) throws BusinessRuleException {
        return service.getByPerson(id);
    }

    @ApiOperation(value = "Cria um novo contato")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Cria um novo contato para uma pessoa"),
            @ApiResponse(code = 500, message = "Não encontra a pessoa")
    })
    @PostMapping("/{idPerson}")
    @Validated
    public ContactDTO add(@PathVariable("idPerson") Integer id,
                          @Valid @RequestBody ContactCreateDTO contact) throws BusinessRuleException {
        return service.add(id, contact);
    }

    @ApiOperation(value = "Atualiza um contato")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Atualiza um contato pelo seu id"),
            @ApiResponse(code = 500, message = "Não encontra o contato")
    })
    @PutMapping("/{idContact}")
    @Validated
    public ContactDTO update(@PathVariable("idContact") Integer id,
                             @Valid @RequestBody ContactCreateDTO contact) throws BusinessRuleException {
        return service.update(id, contact);
    }

    @ApiOperation(value = "Exclui um contato")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Exclui um contato pelo seu id"),
            @ApiResponse(code = 500, message = "Não encontra o contato")
    })
    @DeleteMapping("/{idContact}")
    @Validated
    public ContactDTO delete(@Valid @PathVariable("idContact") Integer id) throws BusinessRuleException {
        return service.remove(id);
    }
}
