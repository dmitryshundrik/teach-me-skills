package by.tms.dao;

import by.tms.entity.Operation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public class HibernateOperationDao implements OperationDao{

//    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Operation operation) {
        Session session = sessionFactory.openSession();
        session.save(operation);
        session.close();
    }

    public List<Operation> findAll() {
        Session session = sessionFactory.openSession();
        List<Operation> operations = session.createQuery("from Operation", Operation.class).getResultList();
        session.close();
        return operations;
    }
}
