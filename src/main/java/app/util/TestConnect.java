package app.util;

import java.sql.Connection;

public class TestConnect {
    public static void main(String[] args) {
       Connection connection = ConnectMySQL.getConnection();
    }


}
