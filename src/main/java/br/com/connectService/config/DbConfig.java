package br.com.connectService.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import javax.sql.DataSource;
import java.net.URI;
import java.net.URISyntaxException;

@Configuration
@Profile("prod")
public class DbConfig {

    @Bean
    public DataSource dataSource() throws URISyntaxException {
        String databaseUrl = System.getenv("DATABASE_URL");
        String jdbcUrl;
        String username;
        String password;

        if (databaseUrl != null && !databaseUrl.isBlank()) {
            URI dbUri = new URI(databaseUrl);
            username = dbUri.getUserInfo().split(":")[0];
            password = dbUri.getUserInfo().split(":")[1];
            jdbcUrl = "jdbc:postgresql://" + dbUri.getHost() + ":" + dbUri.getPort() + dbUri.getPath();
        } else {
            String pgHost = System.getenv("PGHOST");
            String pgPort = System.getenv("PGPORT");
            String pgDatabase = System.getenv("PGDATABASE");
            username = System.getenv("PGUSER");
            password = System.getenv("PGPASSWORD");

            if (pgHost == null || pgPort == null || pgDatabase == null) {
                String dbPublicUrl = System.getenv("DATABASE_PUBLIC_URL");
                if (dbPublicUrl != null && !dbPublicUrl.isBlank()) {
                    URI dbUri = new URI(dbPublicUrl);
                    username = dbUri.getUserInfo().split(":")[0];
                    password = dbUri.getUserInfo().split(":")[1];
                    jdbcUrl = "jdbc:postgresql://" + dbUri.getHost() + ":" + dbUri.getPort() + dbUri.getPath();
                } else {
                    throw new IllegalStateException("Nenhuma variavel de ambiente de banco de dados encontrada (DATABASE_URL, PGHOST ou DATABASE_PUBLIC_URL)");
                }
            } else {
                jdbcUrl = "jdbc:postgresql://" + pgHost + ":" + pgPort + "/" + pgDatabase;
            }
        }

        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(jdbcUrl);
        ds.setUsername(username);
        ds.setPassword(password);
        ds.setDriverClassName("org.postgresql.Driver");
        return ds;
    }
}
