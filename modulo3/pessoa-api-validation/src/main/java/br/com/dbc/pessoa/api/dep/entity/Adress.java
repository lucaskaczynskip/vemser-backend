package br.com.dbc.pessoa.api.dep.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Adress {

    private Integer idAddress;
    private Integer idPerson;

    @NotEmpty
    private String type;

    @NotEmpty
    @Size(max = 250)
    private String address;

    @NotEmpty
    private String number;

    @NotEmpty
    @Size(max = 8)
    private String cep;

    @NotEmpty
    @Size(max = 250)
    private String city;

    @NotEmpty
    private String state;

    @NotEmpty
    private String country;

    public Adress(Integer idAddress, Integer idPerson, String type, String address, String number, String cep, String city, String state, String country) {
        this.idAddress = idAddress;
        this.idPerson = idPerson;
        this.type = type;
        this.address = address;
        this.number = number;
        this.cep = cep;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public Integer getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Integer idAddress) {
        this.idAddress = idAddress;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
