package br.com.dbc.pessoa.api.dep.controller;

import br.com.dbc.pessoa.api.dep.dto.ContactDTO;
import br.com.dbc.pessoa.api.dep.dto.ContactCreateDTO;
import br.com.dbc.pessoa.api.dep.entity.Contact;
import br.com.dbc.pessoa.api.dep.exception.BusinessRuleException;
import br.com.dbc.pessoa.api.dep.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping
    public List<ContactDTO> get() {
        return service.get();
    }

    @GetMapping("/{idContact}")
    public ContactDTO get(@PathVariable("idContact") Integer id) throws BusinessRuleException {
        return service.get(id);
    }

    @GetMapping("/{idPerson}/pessoa")
    public List<ContactDTO> getByPerson(@PathVariable("idPerson") Integer id) throws BusinessRuleException {
        return service.getByPerson(id);
    }

    @PostMapping("/{idPerson}")
    public ContactDTO add(@PathVariable("idPerson") Integer id,
                       @Valid @RequestBody ContactCreateDTO contact) throws BusinessRuleException {
        return service.add(id, contact);
    }

    @PutMapping("/{idContact}")
    public ContactDTO update(@PathVariable("idContact") Integer id,
                          @Valid @RequestBody ContactCreateDTO contact) throws BusinessRuleException {
        return service.update(id, contact);
    }

    @DeleteMapping("/{idContact}")
    public ContactDTO delete(@Valid @PathVariable("idContact") Integer id) throws BusinessRuleException {
        return service.remove(id);
    }
}
