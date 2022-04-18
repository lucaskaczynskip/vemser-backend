package br.com.dbc.pessoa.api.dep.entity;

import java.util.Arrays;

public enum ContactType {
    RESIDENTIAL(1),
    BUSINESS(2);

    private Integer type;

    ContactType(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }

    public static ContactType ofType(Integer type) {
        return Arrays.stream(ContactType.values())
                .filter(tp -> tp.getType().equals(type))
                .findFirst()
                .get();
    }
}
