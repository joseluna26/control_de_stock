package com.alura.jdbc.factory;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

public class ConnectionFactory {
    
     private final DataSource datasource;

    public ConnectionFactory() {
        var poolDatasource = new ComboPooledDataSource();
        poolDatasource.setJdbcUrl("jdbc:mysql://localhost/control_de_stock?useTimeZone=true&serverTimeZone=UTC");
        poolDatasource.setUser("root");
        poolDatasource.setPassword("admin");
        poolDatasource.setMaxPoolSize(10);
        
        this.datasource = poolDatasource;
    }
    
    public Connection recuperaConexion() throws SQLException{
                return this.datasource.getConnection();
    }
}
