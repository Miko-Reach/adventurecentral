package orange.java.pl2.adventurecentral.users.models;

import jakarta.persistence.*;
import jdk.jfr.Event;
import orange.java.pl2.adventurecentral.tickets.models.Ticket;
import orange.java.pl2.adventurecentral.users.enums.RoleName;
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
    private Set<Ticket> generatedTicketsModels;

    @OneToMany(mappedBy = "reservedBy", fetch = FetchType.EAGER)
    private Set<Ticket> reservedTicketsModels;

    @OneToMany(mappedBy="createdBy", fetch = FetchType.EAGER)
    private Set<Event> generatedEvents;
    @Id
    private Long id;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Ticket> getGeneratedTicketsModels() {
        return generatedTicketsModels;
    }

    public void setGeneratedTickets(Set<Ticket> generatedTicketsModels) {
        this.generatedTicketsModels = generatedTicketsModels;
    }

    public Set<Ticket> getReservedTicketsModels() {
        return reservedTicketsModels;
    }

    public void setReservedTickets(Set<Ticket> reservedTicketsModels) {
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

