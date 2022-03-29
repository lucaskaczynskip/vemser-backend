package br.com.dbc.pessoa.api.dep.repository;

import br.com.dbc.pessoa.api.dep.entity.AddressEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Integer> {

    @Query("SELECT ep FROM ENDERECO_PESSOA ep WHERE ep.country = :country")
    List<AddressEntity> findByCountry(String country);

    @Query("SELECT ep FROM ENDERECO_PESSOA ep join fetch ep.persons pe WHERE pe.idPerson = :id")
    List<AddressEntity> findByPersonId(Integer id);

    @Query(value = "SELECT * FROM ENDERECO_PESSOA ep WHERE ep.pais = :country OR ep.cidade = :city", nativeQuery = true)
    List<AddressEntity> findByCountryOrCity(String country, String city);

    @Query(value = "SELECT * FROM ENDERECO_PESSOA ep WHERE COMPLEMENTO IS NULL", nativeQuery = true)
    List<AddressEntity> findAddressWhereComplementIsNull();

    Page<AddressEntity> findByCountryIgnoreCase(Pageable pageable, String country);
}
