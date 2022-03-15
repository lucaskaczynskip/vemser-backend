package br.com.dbc.pessoa.api.dep.controller;

import br.com.dbc.pessoa.api.dep.entity.Adress;
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
    public List<Adress> get() {
        return service.get();
    }

    @GetMapping("/{idAddress}")
    public ResponseEntity<Adress> get(@PathVariable("idAddress") Integer id) throws BusinessRuleException {
        return ResponseEntity.ok(service.get(id));
    }

    @GetMapping("/{idPerson}/pessoa")
    public List<Adress> getByPerson(@PathVariable("idPerson") Integer id) {
        return service.getByPerson(id);
    }

    @PostMapping("/{idPerson}")
    @Validated
    public ResponseEntity<Adress> add(@PathVariable("idPerson") Integer id,
                                      @Valid @RequestBody Adress a) throws BusinessRuleException {
        return ResponseEntity.ok(service.add(id, a));
    }

    @PutMapping("/{idAddress}")
    @Validated
    public ResponseEntity<Adress> update(@PathVariable("idAddress") Integer id,
                                         @Valid @RequestBody Adress a) throws BusinessRuleException {
        return ResponseEntity.ok(service.update(id, a));
    }

    @DeleteMapping("/{idAddress}")
    public ResponseEntity<Adress> remove(@PathVariable("idAddress") Integer id) throws BusinessRuleException {
        return ResponseEntity.ok(service.remove(id));
    }
}
