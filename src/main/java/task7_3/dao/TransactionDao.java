package task7_3.dao;

import jakarta.persistence.EntityManager;
import task7_3.datasource.MariaDbConnection;
import task7_3.entity.TransactionModel;

public class TransactionDao {
    public void addTransaction(TransactionModel newTransaction) {
        EntityManager em = MariaDbConnection.getInstance();
        em.getTransaction().begin();
        em.persist(newTransaction);
        em.getTransaction().commit();
    }
}
