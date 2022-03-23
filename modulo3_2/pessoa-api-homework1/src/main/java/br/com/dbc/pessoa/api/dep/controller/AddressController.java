package br.com.dbc.pessoa.api.dep.controller;

import br.com.dbc.pessoa.api.dep.dto.AddressCreateDTO;
import br.com.dbc.pessoa.api.dep.dto.AddressDTO;
import br.com.dbc.pessoa.api.dep.dto.PersonDTO;
import br.com.dbc.pessoa.api.dep.entity.AddressEntity;
import br.com.dbc.pessoa.api.dep.entity.PersonEntity;
import br.com.dbc.pessoa.api.dep.exception.BusinessRuleException;
import br.com.dbc.pessoa.api.dep.repository.AddressRepository;
import br.com.dbc.pessoa.api.dep.service.AddressService;
import br.com.dbc.pessoa.api.dep.service.EmailService;
import br.com.dbc.pessoa.api.dep.service.PersonService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/endereco")
@AllArgsConstructor
public class AddressController {

    private final AddressService service;
    private final PersonService personService;
    private final EmailService mailService;

    private final AddressRepository repo;

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

//    @ApiOperation(value = "Recebe uma lista de endereços de uma pessoa")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Recebe uma lista de endereços pelo id de uma pessoa"),
//            @ApiResponse(code = 500, message = "Não encontra a pessoa"),
//    })
//    @GetMapping("/{idPerson}/pessoa")
//    public List<AddressDTO> getByPerson(@PathVariable("idPerson") Integer id) {
//        return service.getByPerson(id);
//    }

    @ApiOperation(value = "Cria um novo endereço")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Recebe o endereço criado"),
            @ApiResponse(code = 500, message = "Não encontra a pessoa"),
    })
    @PostMapping
    @Validated
    public ResponseEntity<AddressDTO> add(@Valid @RequestBody AddressCreateDTO a) throws BusinessRuleException {
        AddressDTO created = service.add(a);

//        PersonDTO person = personService.get(id);
//
//        StringBuilder message = new StringBuilder();
//        message.append("Novo endereço cadastrado no seu perfil.\n");
//        message.append("O endereço: " + created.getAddress() + " " + created.getNumber() + " foi cadastrado.");
//
//        mailService.sendEmail(message.toString(), "Novo endereço cadastrado", "Olá " + person.getName(), person.getEmail());

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
//        AddressDTO pastAddress = service.get(id);
//
//        PersonDTO person = personService.get(updated.getIdPerson());
//
//        StringBuilder message = new StringBuilder();
//        message.append("Um endereço foi atualizado no seu perfil.\n");
//        message.append("O antigo endereço: " + pastAddress.getAddress() + " " + pastAddress.getNumber() + " foi atualizado.");
//
//        mailService.sendEmail(message.toString(), "Endereço atualizado", "Olá " + person.getName(), person.getEmail());

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
//
//        PersonDTO person = personService.get(removed.getIdPerson());
//
//        StringBuilder message = new StringBuilder();
//        message.append("Um endereço foi removido do seu perfil.\n");
//        message.append("O endereço: " + removed.getAddress() + " " + removed.getNumber() + " foi excluído.");
//
//        mailService.sendEmail(message.toString(), "Endereço removido", "Olá " + person.getName(), person.getEmail());

        return ResponseEntity.ok(removed);
    }

    @GetMapping("/by-country")
    public List<AddressEntity> findByCountry(@RequestParam("country") String country) {
        return repo.findByCountry(country);
    }

    @GetMapping("/by-person")
    public List<AddressEntity> findByPersonId(@RequestParam("id") Integer id) {
        return repo.findByPersonId(id);
    }

    @GetMapping("/by-city-or-country")
    public List<AddressEntity> findByCountryOrCity(@RequestParam(value = "country", required = false) String country,
                                                   @RequestParam(value = "city", required = false) String city) {
        return repo.findByCountryOrCity(country, city);
    }

    @GetMapping("/where-complement-is-null")
    public List<AddressEntity> findAddressWhereComplementIsNull() {
        return repo.findAddressWhereComplementIsNull();
    }
}
