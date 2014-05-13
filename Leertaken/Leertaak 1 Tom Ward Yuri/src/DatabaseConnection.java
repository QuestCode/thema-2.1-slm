/**
 * Created by Yuri on 13/5/2014.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class DatabaseConnection {
    private static final String hostname = "jdbc:postgresql://95.85.63.58:5432/one";
    private static final String username = "one";
    private static final String password = "Tr3ll0?";

    private Connection databaseConnection;

    public DatabaseConnection(){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e){
            System.out.println("Class not found");
        }

        try {
            databaseConnection = DriverManager.getConnection(hostname, username, password);
            System.out.println("Database connection established");

        } catch (Exception e){
            System.out.println("Database connection failed: " + e.getMessage());
        }


    }

    public void sendMessage(Message message){

    }
}
