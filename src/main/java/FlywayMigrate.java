import org.flywaydb.core.Flyway;

public class FlywayMigrate {
    public static void startMigrateDB(){
        Flyway flyway = Flyway.configure().dataSource("jdbc:postgresql://localhost:5432/journal", "postgres", "postgres").load();
        flyway.repair();
        flyway.clean();
        flyway.migrate();
    }

    public static void main(String[] args) {
        startMigrateDB();
    }
}
