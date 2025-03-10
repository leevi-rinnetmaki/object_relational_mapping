package task7_4.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import jakarta.persistence.*;

public class MariaDbConnection {

    private static EntityManagerFactory emf = null;
    private static EntityManager em = null;

    public static EntityManager getInstance() {
        // you need to add synchronization if you run in a multi-threaded environment

        if (em==null) {
            if (emf==null) {
                emf = Persistence.createEntityManagerFactory("CompanyMariaDbUnit");
            }
            em = emf.createEntityManager();
        }
        return em;
    }


    private static Connection conn = null;

    public static Connection getConnection() {
        if (conn==null) {
            // connect if necessary
            try {
                conn = DriverManager.getConnection(
                        "jdbc:mariadb://localhost:3306/currency2?user=appuser2&password=password");
            } catch (SQLException e) {
                System.out.println("Connection failed.");
                e.printStackTrace();
            }
            return conn;
        }
        else {
            return conn;
        }
    }

    public static void terminate() {
        try {
            getConnection().close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}