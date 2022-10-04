package app.DAO;
import app.model.User;
import app.util.ConnectMySQL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TestGetUsers {

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        Connection connection = ConnectMySQL.getConnection();
        try {
            Statement statement = connection.createStatement();
            String SQL = "Select * from users";
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setname(resultSet.getString("name"));
                System.out.println(user);
                users.add(user);
            }
        } catch(SQLException e) {
                 e.printStackTrace();
        }
for(User user: users) {
    System.out.println(user);
}
    }
}
