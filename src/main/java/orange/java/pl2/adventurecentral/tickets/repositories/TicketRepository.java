package orange.java.pl2.adventurecentral.tickets.repositories;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.websocket.Session;
import orange.java.pl2.adventurecentral.tickets.TicketType;
import orange.java.pl2.adventurecentral.tickets.models.Ticket;
import org.hibernate.query.Query;

import java.util.List;

public class TicketRepository {
    public TicketRepository() {
    }

    public static List<Ticket> getAll() throws DatabaserException {
        return DBOperator.getAll(Ticket.class);
    }

    public static List<Ticket> getByType(TicketType ticketType) throws DatabaserException {
        try {
            Session session = SFManager.getDefaultSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Ticket> criteriaQuery = builder.createQuery(Ticket.class);
            Root<Ticket> root = criteriaQuery.from(Ticket.class);
            criteriaQuery.select(root);
            criteriaQuery.where(builder.equal(root.get("type"), ticketType));
            Query<Ticket> q = session.createQuery(criteriaQuery);
            List<Ticket> results = q.getResultList();
            session.close();
            return results;
        } catch (Exception var7) {
            throw new DatabaserException(var7);
        }
    }

    public static void removeAll() throws DatabaserException {
        DBOperator.commit((session) -> {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaDelete<Ticket> criteriaQuery = builder.createCriteriaDelete(Ticket.class);
            criteriaQuery.from(Ticket.class);
            session.createQuery(criteriaQuery).executeUpdate();
        });
    }

    public static Long count() throws DatabaserException {
        try {
            Session session = SFManager.getDefaultSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Long> criteriaQuery = builder.createQuery(Long.class);
            criteriaQuery.select(builder.count(criteriaQuery.from(Ticket.class)));
            Long count = (Long)session.createQuery(criteriaQuery).getSingleResult();
            session.close();
            return count;
        } catch (Exception var4) {
            throw new DatabaserException(var4);
        }
    }
}
