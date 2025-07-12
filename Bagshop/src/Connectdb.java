import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connectdb {

    public static Connection connect() {
        Connection connection = null;
        try {
            // Load UCanAccess driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            
            // Database path and connection URL
            String dbPath = "D:\\java program\\Bagshop.accdb";
            String url = "jdbc:ucanaccess://" + dbPath;
            
            // Establish the connection
            connection = DriverManager.getConnection(url);
            System.out.println("Connection successful!");

        } catch (ClassNotFoundException e) {
            // Handle exception if driver is not found
            System.err.println("UCanAccess driver not found: " + e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            // Handle SQL exceptions
            System.err.println("SQL Exception: " + e.getMessage());
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) {
        // Just connect to the database (with logging)
        Connection conn = connect();
        if (conn != null) {
            try {
                // Close the connection after use
                conn.close();
                System.out.println("Connection closed.");
            } catch (SQLException e) {
                // Handle exception when closing the connection
                System.err.println("Failed to close connection: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("Failed to establish connection.");
        }
    }
}
