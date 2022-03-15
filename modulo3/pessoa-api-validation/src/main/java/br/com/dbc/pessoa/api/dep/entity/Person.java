package br.com.dbc.pessoa.api.dep.entity;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Date;

public class Person {

    private Integer idPerson;

    @NotEmpty
    private String name;

    @NotEmpty
    @Email
    private String email;

    @NotNull
    @CPF
    @Size(max = 11)
    private String cpf;

    @NotNull
    @Past
    private LocalDate date;

    public Person(Integer idPerson, String name, String email, String cpf, LocalDate date) {
        this.idPerson = idPerson;
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.date = date;
    }

    public Integer getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
