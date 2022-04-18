package br.com.dbc.pessoa.api.dep.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity(name = "GROUPS")
public class GroupEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GROUPS")
    @SequenceGenerator(name = "SEQ_GROUPS", sequenceName = "SEQ_GROUPS", allocationSize = 1)
    private Integer idGroup;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "groups")
    private List<LoginEntity> logins;

    @ManyToMany
    @JoinTable(
            name = "GROUPS_ROLES",
            joinColumns = @JoinColumn(name = "id_group"),
            inverseJoinColumns = @JoinColumn(name = "id_role")
    )
    private Set<RoleEntity> roles;
}
