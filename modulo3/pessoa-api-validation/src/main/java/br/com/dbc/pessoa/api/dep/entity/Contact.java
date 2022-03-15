package br.com.dbc.pessoa.api.dep.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Contact {

    private Integer idContact;
    private Integer idPerson;

    @NotEmpty
    private String type;

    @NotEmpty
    @Size(max = 13)
    private String number;

    @NotEmpty
    private String description;

    public Contact(Integer idContact, Integer idPerson, String type, String number, String description) {
        this.idContact = idContact;
        this.idPerson = idPerson;
        this.type = type;
        this.number = number;
        this.description = description;
    }

    public Integer getIdContact() {
        return idContact;
    }

    public void setIdContact(Integer idContact) {
        this.idContact = idContact;
    }

    public Integer getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
