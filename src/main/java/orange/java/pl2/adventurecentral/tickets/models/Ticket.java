package orange.java.pl2.adventurecentral.tickets.models;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jdk.jfr.Event;
import orange.java.pl2.adventurecentral.tickets.TicketType;
import org.apache.catalina.User;

import java.util.Objects;


public class Ticket {

    private String title;

    private String description;

    private Double price;

    private Boolean reserved;

    @Enumerated(EnumType.STRING)
    private TicketType type;

    @ManyToOne(fetch = FetchType.EAGER)
    private User createdBy;

    @ManyToOne(fetch = FetchType.EAGER)
    private User reservedBy;

    @ManyToOne(fetch = FetchType.EAGER)
    private Event event;


    public Ticket() {
        this.reserved = false;
    }

    public Ticket(String title, String description, Double price, Boolean reserved, TicketType type, User createdBy) {
        this();
        this.title = title;
        this.description = description;
        this.price = price;
        this.reserved = reserved;
        this.type = type;
        this.createdBy = createdBy;
    }

    public Ticket(String title, String description, Double price) {
        this();
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getReserved() {
        return reserved;
    }

    public void setReserved(Boolean reserved) {
        this.reserved = reserved;
    }

    public TicketType getType() {
        return type;
    }

    public void setType(TicketType type) {
        this.type = type;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public User getReservedBy() {
        return reservedBy;
    }

    public void setReservedBy(User reservedBy) {
        this.reservedBy = reservedBy;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(getId(), ticket.getId());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
