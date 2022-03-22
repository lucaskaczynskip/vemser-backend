package br.com.dbc.pessoa.api.dep.entity;

import java.util.Arrays;

public enum AddressType {
    RESIDENTIAL(1),
    BUSINESS(2);

    private Integer type;

    AddressType(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }

    public static AddressType ofType(Integer type) {
        return Arrays.stream(AddressType.values())
                .filter(tp -> tp.getType().equals(type))
                .findFirst()
                .get();
    }
}
