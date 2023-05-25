package orange.java.pl2.adventurecentral.users.models;

import jakarta.persistence.*;
import orange.java.pl2.adventurecentral.users.enums.RoleName;

@Entity
@Table(name="role")
public class Role extends BaseModel {

    @Enumerated(EnumType.ORDINAL)
    private Role roleName;
    @Id
    private Long id;

    public Role() {
    }

    public RoleName(RoleName roleName) {
        this();
        this.roleName = roleName;
    }

    public RoleName getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
