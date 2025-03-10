package task7_4.dao;

import jakarta.persistence.EntityManager;
import task7_4.datasource.MariaDbConnection;
import task7_4.entity.TransactionModel;

public class TransactionDao {
    public void addTransaction(TransactionModel newTransaction) {
        EntityManager em = MariaDbConnection.getInstance();
        em.getTransaction().begin();
        em.persist(newTransaction);
        em.getTransaction().commit();
    }
}
