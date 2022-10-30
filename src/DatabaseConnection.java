import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public static Connection connection = null;
    public static Connection connectToDataBase(){
        try {
            connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/librjava",
                            "root","akej");
            if (connection == null) {
                System.out.println("No connection");
            }else{
                System.out.println("Successfully connected");
            }
            //return connection;
        }catch(Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}