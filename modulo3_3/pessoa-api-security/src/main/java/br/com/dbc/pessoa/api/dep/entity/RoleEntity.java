package br.com.dbc.pessoa.api.dep.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity(name = "ROLES")
public class RoleEntity implements Serializable, GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ROLE")
    @SequenceGenerator(name = "SEQ_ROLE", sequenceName = "seq_roles", allocationSize = 1)
    @Column(name = "id_role")
    private Integer idRole;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<GroupEntity> groupsRole;

    @Override
    public String getAuthority() {
        return this.name;
    }
}
