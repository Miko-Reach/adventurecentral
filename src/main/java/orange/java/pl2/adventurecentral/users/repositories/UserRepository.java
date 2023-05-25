package orange.java.pl2.adventurecentral.users.repositories;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.apache.catalina.User;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class UserRepository
        public UserRepository() {
        }
        public static List<User> getAll() throws DatabaserException {
            return DBOperator.getAll(User.class);
        }
        public static User getByLogin(String login) throws DatabaserException {
            List<User> results = new ArrayList();
            DBOperator.commit((session) -> {
                CriteriaBuilder builder = session.getCriteriaBuilder();
                CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
                Root<User> root = criteriaQuery.from(User.class);
                criteriaQuery.select(root);
                criteriaQuery.where(builder.equal(root.get("login"), login));
                Query<User> q = session.createQuery(criteriaQuery);
                results.addAll(q.getResultList());
            });
            return results.size() == 0 ? null : (User)results.get(0);
        }

        public static void removeAll() throws DatabaserException {
            DBOperator.commit((session) -> {
                CriteriaBuilder builder = session.getCriteriaBuilder();
                CriteriaDelete<User> criteriaQuery = builder.createCriteriaDelete(User.class);
                criteriaQuery.from(User.class);
                session.createQuery(criteriaQuery).executeUpdate();
            });
        }
}
