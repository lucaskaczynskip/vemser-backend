package br.com.dbc.pessoa.api.dep.repository;

import br.com.dbc.pessoa.api.dep.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Integer> {

}
