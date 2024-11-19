package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;



/**
 * ConnectionManager to connect to your database instance.
 * 
 * This class uses the MySQL Connector/J driver to connect to your local MySQL instance.
 * Follow the provided steps to correctly set up and use this ConnectionManager.
 */
public class ConnectionManager {

    // User to connect to your database instance. Adjust as needed.
    private final String user = "root";
    // Password for the user. Replace with your own password.
    private final String password = "rootpassword";
    // URI to your database server. Default is "localhost".
    private final String hostName = "localhost";
    // Port to your database server. Default MySQL port is 3306.
    private final int port = 3306;
    // Name of the MySQL schema that contains your tables.
    private final String schema = "cs5200project";
    // Default timezone for MySQL server.
    private final String timezone = "UTC";

    public Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            Properties connectionProperties = new Properties();
            connectionProperties.put("user", this.user);
            connectionProperties.put("password", this.password);
            connectionProperties.put("serverTimezone", this.timezone);

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                throw new SQLException(e);
            }
            connection = DriverManager.getConnection(
                "jdbc:mysql://" + this.hostName + ":" + this.port + "/" + this.schema + "?useSSL=false",
                connectionProperties);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return connection;
    }

    public void closeConnection(Connection connection) throws SQLException {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw e;
            }
        }
    }

    // test whether I can successfully access to the db
    public static void main(String[] args) {
        ConnectionManager connectionManager = new ConnectionManager();
        try (Connection connection = connectionManager.getConnection()) {
            if (connection != null) {
                System.out.println("Successfully Access to the DB");
            }
        } catch (SQLException e) {
            System.err.println("Access Unsuccessfully：" + e.getMessage());
        }
    }
    
}

