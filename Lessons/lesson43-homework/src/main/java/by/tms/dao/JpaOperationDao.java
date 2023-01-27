package by.tms.dao;

import by.tms.entity.Operation;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class JpaOperationDao implements OperationDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Operation operation) {
        entityManager.persist(operation);
    }

    @Override
    public List<Operation> findAll() {
        TypedQuery<Operation> query = entityManager.createNamedQuery("Operation.findAll", Operation.class);
        return query.getResultList();
    }
}
