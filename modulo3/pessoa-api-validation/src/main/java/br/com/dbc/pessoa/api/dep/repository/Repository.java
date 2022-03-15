package br.com.dbc.pessoa.api.dep.repository;

import br.com.dbc.pessoa.api.dep.exception.BusinessRuleException;

import java.util.List;

public interface Repository<KEY, OBJECT> {

   List<OBJECT> getAll();
   OBJECT getById(KEY id) throws BusinessRuleException;
   OBJECT create(OBJECT object) throws BusinessRuleException;
   OBJECT update(KEY id, OBJECT object) throws BusinessRuleException;
   OBJECT delete(KEY id) throws BusinessRuleException;
}
