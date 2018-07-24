package br.com.ultra.stforfv.infrastructure.database;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.sql.SQLException;

/**
 * Created by Jhoni on 24/11/2017.
 */
@Configuration
@EnableTransactionManagement
@Component
public class DBConnection {

//    @Autowired
    private DB db;

    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    @Bean
    public DataSource createDataSource() {
        dataSource = new DataSource();
        jdbcTemplate = new JdbcTemplate();
//        setDataSource(this.db!=null? this.db : new DB("ULTRASERVER", "3050", "ultra-db", "D:/ftp/clientes/bancos/provina_nf.fdb"));
//        setDataSource(this.db!=null? this.db : new DB("ULTRASERVER", "3050", "ultra-db", "D:/ftp/clientes/bancos/kgepel.fdb"));
        setDataSource(this.db!=null? this.db : new DB("ULTRASERVER", "3050", "ultra-db", "D:/ftp/clientes/bancos/TOPVET.fdb"));

        return dataSource;
    }


    public void setDataSource(DB db){
        this.db = db;
        dataSource.close();
        dataSource.setDriverClassName("org.firebirdsql.jdbc.FBDriver");
        dataSource.setUrl("jdbc:firebirdsql:" + db.getHost() + "/" + db.getPorta() + ":" + db.getUrl() + "?encoding=ISO8859_1");
        dataSource.setUsername(db.getUsername());
        dataSource.setPassword(db.getPassword());
        try {
            dataSource.createPool();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public void setConnection(){
        jdbcTemplate.setDataSource(dataSource);
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}
