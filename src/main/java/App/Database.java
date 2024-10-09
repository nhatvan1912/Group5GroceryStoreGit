package App;

import javafx.application.Application;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private final static String url = "jdbc:mysql://localhost:3306/listaccount";
    private final static String username = "root";
    private final static String password = "";
    public static Connection connectDB(){
        try{
            Connection connect = DriverManager.getConnection(url, username, password);
            return connect;
        }catch(SQLException e){e.printStackTrace();}
        return null;
    }
}
