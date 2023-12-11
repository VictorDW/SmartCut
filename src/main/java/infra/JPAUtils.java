package infra;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtils {
    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("smartcut_sena");
    public static EntityManager getEntityManager() {
        return FACTORY.createEntityManager();
    }
}
