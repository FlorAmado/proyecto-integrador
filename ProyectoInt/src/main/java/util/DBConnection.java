
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.activation.DataSource;
import static jdk.nashorn.internal.codegen.CompilerConstants.className;
import org.apache.commons.dbcp2.BasicDataSource;


public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/sysdb?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String DRIVER = "com.mysql.oj.jdbc.Driver";
    private static Connection connection = null;

    public static Connection getConnection(){
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("Conectado");
        }catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return connection;
    }

//    private static BasicDataSource dataSource = null;
//
//    private static DataSource getDataSource() {
//        if (dataSource == null) {
//            dataSource = new BasicDataSource();
//            dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//            dataSource.setUsername("root");
//            dataSource.setPassword("root");
//            dataSource.setUrl("jdbc:mysql://localhost:3306/sysdb?useTimezone=true&serverTimezone=UTC");
//            dataSource.setInitialSize(20);
//            dataSource.setMaxIdle(15);
//            dataSource.setMaxTotal(20);
//            dataSource.setMaxWaitMillis(5000);
//        }
//        return (DataSource) dataSource;
//    }
//
//    public static Connection getConnection() throws SQLException {
//        return getDataSource().getConnection();
//    }
}
