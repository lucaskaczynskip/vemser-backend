package br.com.dbc.pessoa.api.dep.controller;

import br.com.dbc.pessoa.api.dep.entity.AddressEntity;
import br.com.dbc.pessoa.api.dep.entity.ContactEntity;
import br.com.dbc.pessoa.api.dep.entity.PersonEntity;
import br.com.dbc.pessoa.api.dep.repository.AddressRepository;
import br.com.dbc.pessoa.api.dep.repository.ContactRepository;
import br.com.dbc.pessoa.api.dep.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paged")
@AllArgsConstructor
public class PaginationController {

    private final ContactRepository contactRepository;
    private final AddressRepository addressRepository;

    @GetMapping("/find-all-contacts-ordered-by-description")
    public Page<ContactEntity> findAllContactsOrderByDesc(Integer solicited, Integer pageSize) {
        Pageable pageable = PageRequest.of(solicited, pageSize, Sort.by("description"));
        return contactRepository.findAll(pageable);
    }

    @GetMapping("/find-all-addresses-ordered-by-cep")
    public Page<AddressEntity> findAllAddressOrderByCep(Integer solicited, Integer pageSize) {
        Pageable pageable = PageRequest.of(solicited, pageSize, Sort.by("cep"));
        return addressRepository.findAll(pageable);
    }

    @GetMapping("/find-all-addresses-filtred-by-country")
    public Page<AddressEntity> findAllOrderByCountryIgnoreCase(@RequestParam("country") String country,
                                                               Integer solicited,
                                                               Integer pageSize) {
        return addressRepository.findByCountryIgnoreCase(PageRequest.of(solicited, pageSize), country);
    }
}
