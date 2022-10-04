package app.util;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectMySQL {

    private static final String URL ="jdbc:mysql://localhost:3306/pp231?verifyServerCertificate=false&useSSL=false&requireSSL=false&useLegacyDatetimeCode=false&amp&serverTimezone=UTC";
    private static final String USER ="root";
    private static final String PASSWORD ="root";
    private static Connection connection;
    private static final Logger LOGGER = Logger.getLogger("ConnectMySqlLogger");
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            LOGGER.log(Level.INFO,"Class Driver: OK");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            LOGGER.log(Level.INFO, "GetConnection: OK!");
        } catch (ClassNotFoundException|SQLException  e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() {return connection;}
}
