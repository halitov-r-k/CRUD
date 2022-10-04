package app.DAO;

import app.model.User;
import app.util.ConnectMySQL;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class UserDAO {
    private static final Logger LOGGER = Logger.getLogger("UserDAO");
   public List<User> getUsers() {
       LOGGER.log(Level.INFO, "start");
       List<User> users = new ArrayList<User>();
       Connection connection = ConnectMySQL.getConnection();
       try {
           Statement statement = connection.createStatement();
           String SQL = "Select * from users";
           ResultSet resultSet = statement.executeQuery(SQL);
           while (resultSet.next()) {
               User user = new User();
               user.setId(resultSet.getLong("id"));
               user.setname(resultSet.getString("name"));
               users.add(user);
              LOGGER.log(Level.INFO, "Add user: " + user);
           }
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
       return users;
   }
}
