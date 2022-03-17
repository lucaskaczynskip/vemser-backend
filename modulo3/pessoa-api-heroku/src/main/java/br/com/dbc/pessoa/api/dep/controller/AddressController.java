package br.com.dbc.pessoa.api.dep.controller;

import br.com.dbc.pessoa.api.dep.dto.AddressCreateDTO;
import br.com.dbc.pessoa.api.dep.dto.AddressDTO;
import br.com.dbc.pessoa.api.dep.dto.PersonDTO;
import br.com.dbc.pessoa.api.dep.entity.Address;
import br.com.dbc.pessoa.api.dep.exception.BusinessRuleException;
import br.com.dbc.pessoa.api.dep.service.AddressService;
import br.com.dbc.pessoa.api.dep.service.EmailService;
import br.com.dbc.pessoa.api.dep.service.PersonService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/endereco")
public class AddressController {

    @Autowired
    private AddressService service;

    @Autowired
    private PersonService personService;

    @Autowired
    private EmailService mailService;

    @ApiOperation(value = "Recebe uma lista de endereços")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Recebe uma lista de endereços")
    })
    @GetMapping
    public List<AddressDTO> get() {
        return service.get();
    }

    @ApiOperation(value = "Recebe um endereço")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Recebe um endereço pelo seu id"),
            @ApiResponse(code = 500, message = "Não encontra o endereço"),
    })
    @GetMapping("/{idAddress}")
    public ResponseEntity<AddressDTO> get(@PathVariable("idAddress") Integer id) throws BusinessRuleException {
        return ResponseEntity.ok(service.get(id));
    }

    @ApiOperation(value = "Recebe uma lista de endereços de uma pessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Recebe uma lista de endereços pelo id de uma pessoa"),
            @ApiResponse(code = 500, message = "Não encontra a pessoa"),
    })
    @GetMapping("/{idPerson}/pessoa")
    public List<AddressDTO> getByPerson(@PathVariable("idPerson") Integer id) {
        return service.getByPerson(id);
    }

    @ApiOperation(value = "Cria um novo endereço para uma pessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Recebe o endereço criado"),
            @ApiResponse(code = 500, message = "Não encontra a pessoa"),
    })
    @PostMapping("/{idPerson}")
    @Validated
    public ResponseEntity<AddressDTO> add(@PathVariable("idPerson") Integer id,
                                       @Valid @RequestBody AddressCreateDTO a) throws BusinessRuleException {
        AddressDTO created = service.add(id, a);

        PersonDTO person = personService.get(id);

        StringBuilder message = new StringBuilder();
        message.append("Novo endereço cadastrado no seu perfil.\n");
        message.append("O endereço: " + created.getAddress() + " " + created.getNumber() + " foi cadastrado.");

        mailService.sendEmail(message.toString(), "Novo endereço cadastrado", "Olá " + person.getName(), person.getEmail());

        return ResponseEntity.ok(created);
    }

    @ApiOperation(value = "Atualiza um endereço")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Recebe o endereço atualizado"),
            @ApiResponse(code = 500, message = "Não encontra o endereço"),
    })
    @PutMapping("/{idAddress}")
    @Validated
    public ResponseEntity<AddressDTO> update(@PathVariable("idAddress") Integer id,
                                          @Valid @RequestBody AddressCreateDTO a) throws BusinessRuleException {
        AddressDTO updated = service.update(id, a);
        AddressDTO pastAddress = service.get(id);

        PersonDTO person = personService.get(updated.getIdPerson());

        StringBuilder message = new StringBuilder();
        message.append("Um endereço foi atualizado no seu perfil.\n");
        message.append("O antigo endereço: " + pastAddress.getAddress() + " " + pastAddress.getNumber() + " foi atualizado.");

        mailService.sendEmail(message.toString(), "Endereço atualizado", "Olá " + person.getName(), person.getEmail());

        return ResponseEntity.ok(updated);
    }

    @ApiOperation(value = "Exclui um endereço")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Recebe o endereço excluido"),
            @ApiResponse(code = 500, message = "Não encontra o endereço"),
    })
    @DeleteMapping("/{idAddress}")
    public ResponseEntity<AddressDTO> remove(@PathVariable("idAddress") Integer id) throws BusinessRuleException {
        AddressDTO removed = service.remove(id);

        PersonDTO person = personService.get(removed.getIdPerson());

        StringBuilder message = new StringBuilder();
        message.append("Um endereço foi removido do seu perfil.\n");
        message.append("O endereço: " + removed.getAddress() + " " + removed.getNumber() + " foi excluído.");

        mailService.sendEmail(message.toString(), "Endereço removido", "Olá " + person.getName(), person.getEmail());

        return ResponseEntity.ok(removed);
    }
}
