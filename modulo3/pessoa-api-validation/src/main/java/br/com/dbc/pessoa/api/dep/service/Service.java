package br.com.dbc.pessoa.api.dep.service;

import br.com.dbc.pessoa.api.dep.exception.BusinessRuleException;

import java.util.List;

public interface Service<KEY, OBJECT> {

    List<OBJECT> get();
    OBJECT get(KEY id) throws BusinessRuleException;
    OBJECT add(OBJECT object) throws BusinessRuleException;
    OBJECT update(KEY id, OBJECT object) throws BusinessRuleException;
    OBJECT remove(KEY id) throws BusinessRuleException;
}
