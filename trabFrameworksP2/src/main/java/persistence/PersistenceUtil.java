package persistence;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PersistenceUtil {
    private static EntityManagerFactory entityManagerFactory;

    public static EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null) {
            Map<String, String> jpaProperties = new HashMap<>();

            String dbUrl = Objects.requireNonNullElse(System.getenv("TASK_APP_DATABASE_URL"),
                    "jdbc:mysql://localhost:3306/task_bot_app");
            String dbUsername = Objects.requireNonNullElse(System.getenv("TASK_APP_DATABASE_USERNAME"), "root");
            String dbPassword = Objects.requireNonNullElse(System.getenv("TASK_APP_DATABASE_PASSWORD"), "");

            jpaProperties.put("javax.persistence.jdbc.url", dbUrl);
            jpaProperties.put("javax.persistence.jdbc.user", dbUsername);
            jpaProperties.put("javax.persistence.jdbc.password", dbPassword);

            entityManagerFactory = Persistence.createEntityManagerFactory("persistenceConfig", jpaProperties);
        }

        return entityManagerFactory;
    }

    public static void close(EntityManagerFactory emf) {
        if (emf != null) {
            emf.close();
        }
    }
}
