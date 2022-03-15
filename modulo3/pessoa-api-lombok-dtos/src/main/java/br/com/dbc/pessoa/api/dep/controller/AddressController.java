package br.com.dbc.pessoa.api.dep.controller;

import br.com.dbc.pessoa.api.dep.dto.AddressCreateDTO;
import br.com.dbc.pessoa.api.dep.dto.AddressDTO;
import br.com.dbc.pessoa.api.dep.entity.Address;
import br.com.dbc.pessoa.api.dep.exception.BusinessRuleException;
import br.com.dbc.pessoa.api.dep.service.AddressService;
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

    @GetMapping
    public List<AddressDTO> get() {
        return service.get();
    }

    @GetMapping("/{idAddress}")
    public ResponseEntity<AddressDTO> get(@PathVariable("idAddress") Integer id) throws BusinessRuleException {
        return ResponseEntity.ok(service.get(id));
    }

    @GetMapping("/{idPerson}/pessoa")
    public List<AddressDTO> getByPerson(@PathVariable("idPerson") Integer id) {
        return service.getByPerson(id);
    }

    @PostMapping("/{idPerson}")
    @Validated
    public ResponseEntity<AddressDTO> add(@PathVariable("idPerson") Integer id,
                                       @Valid @RequestBody AddressCreateDTO a) throws BusinessRuleException {
        return ResponseEntity.ok(service.add(id, a));
    }

    @PutMapping("/{idAddress}")
    @Validated
    public ResponseEntity<AddressDTO> update(@PathVariable("idAddress") Integer id,
                                          @Valid @RequestBody AddressCreateDTO a) throws BusinessRuleException {
        return ResponseEntity.ok(service.update(id, a));
    }

    @DeleteMapping("/{idAddress}")
    public ResponseEntity<AddressDTO> remove(@PathVariable("idAddress") Integer id) throws BusinessRuleException {
        return ResponseEntity.ok(service.remove(id));
    }
}
