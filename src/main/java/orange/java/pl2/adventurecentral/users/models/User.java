package orange.java.pl2.adventurecentral.users.models;

import jakarta.persistence.*;
import jdk.jfr.Event;
import orange.java.pl2.adventurecentral.tickets.TicketModels;
import orange.java.pl2.adventurecentral.users.RoleName;
import org.hibernate.annotations.Table;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="user")
public class User extends BaseModel {

    private String login;

    private String password;

    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "role_id") })
    private Set<Role> roles;

    @OneToMany(mappedBy="createdBy", fetch = FetchType.EAGER)
    private Set<TicketModels> generatedTicketsModels;

    @OneToMany(mappedBy = "reservedBy", fetch = FetchType.EAGER)
    private Set<TicketModels> reservedTicketsModels;

    @OneToMany(mappedBy="createdBy", fetch = FetchType.EAGER)
    private Set<Event> generatedEvents;
    @Id
    private Long id;

    /**
     * Instantiates a new User.
     */
    public User() {
        this.roles = new HashSet<>();
        this.generatedTicketsModels = new HashSet<>();
        this.reservedTicketsModels = new HashSet<>();
    }

    public User(String login, String password, RoleName roleName) {
        this();
        this.login = login;
        this.password = password;
        this.roles.add(new Role());
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets roles.
     *
     * @return the roles
     */
    public Set<Role> getRoles() {
        return roles;
    }

    /**
     * Sets roles.
     *
     * @param roles the roles
     */
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    /**
     * Gets generated tickets.
     *
     * @return the generated tickets
     */
    public Set<TicketModels> getGeneratedTicketsModels() {
        return generatedTicketsModels;
    }

    public void setGeneratedTickets(Set<TicketModels> generatedTicketsModels) {
        this.generatedTicketsModels = generatedTicketsModels;
    }

    /**
     * Gets reserved tickets.
     *
     * @return the reserved tickets
     */
    public Set<TicketModels> getReservedTicketsModels() {
        return reservedTicketsModels;
    }

    public void setReservedTickets(Set<TicketModels> reservedTicketsModels) {
        this.reservedTicketsModels = reservedTicketsModels;
    }
    public Set<Event> getGeneratedEvents() {
        return generatedEvents;
    }

    public void setGeneratedEvents(Set<Event> generatedEvents) {
        this.generatedEvents = generatedEvents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

