package task7_3;
import jakarta.persistence.*;


public class JpaTest {
    public static void main(String[] args) {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("CompanyMariaDbUnit");
            System.out.println("EntityManagerFactory created successfully!");
            emf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}