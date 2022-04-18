package br.com.dbc.pessoa.api.dep.service;

import br.com.dbc.pessoa.api.dep.entity.GroupEntity;
import br.com.dbc.pessoa.api.dep.exception.BusinessRuleException;
import br.com.dbc.pessoa.api.dep.repository.GroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class GroupService {

    private final GroupRepository groupRepository;

    public GroupEntity findById(Integer id) throws Exception {
        Optional<GroupEntity> group = this.groupRepository.findById(id);
        if (group.isPresent()) {
            return group.get();
        }
        throw new BusinessRuleException("Group not found.");
    }
}
