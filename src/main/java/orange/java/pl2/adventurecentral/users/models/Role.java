package orange.java.pl2.adventurecentral.users.models;

import jakarta.persistence.*;
import orange.java.pl2.adventurecentral.users.RoleName;

@Entity
@Table(name="role")
public class Role extends BaseModel {

    @Enumerated(EnumType.ORDINAL)
    private RoleName roleName;
    @Id
    private Long id;

    /**
     * Instantiates a new Role.
     */
    public Role() {
    }

    /**
     * Instantiates a new Role.
     *
     * @param roleName the role name
     */
    public Role(RoleName roleName) {
        this();
        this.roleName = roleName;
    }

    /**
     * Gets role name.
     *
     * @return the role name
     */
    public RoleName getRoleName() {
        return roleName;
    }

    /**
     * Sets role name.
     *
     * @param roleName the role name
     */
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
