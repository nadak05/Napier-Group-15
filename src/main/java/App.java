import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class App {

    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    public static void main(String[] args) throws IOException {
        // Create new Application
        App a = new App();

        if (args.length < 1) {
            System.out.println("Usage test");
            a.connect("localhost:33060", 0);
        } else {
            a.connect(args[0], Integer.parseInt(args[1]));
            System.out.println("check " + args[0] + " " + args[1]);
        }

        // Instead of writing to a file, generate and print the report
        String report = a.report1();
        System.out.println(report);  // For logging, or it can be used in the tests directly.

        // Disconnect from database
        a.disconnect();
    }

    /**
     * Generates a report based on data from the database.
     * Instead of writing to a file, this returns a String for integration test validation.
     *
     * @return Report data as a String
     */
    public String report1() {
        StringBuilder sb = new StringBuilder();
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String sql = "select name, population from country order by population desc";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(sql);
            // Cycle through the result set and build report
            while (rset.next()) {
                String name = rset.getString("name");
                Integer population = rset.getInt("population");
                sb.append(name).append("\t").append(population).append("\r\n");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
            return "Failed to fetch data from database";
        }

        return sb.toString();  // Return the generated report string
    }

    /**
     * Connect to the MySQL database.
     *
     * @param conString
     * 		Use db:3306 for docker and localhost:33060 for local or Integration Tests TEST
     * @param delay
     */
    public void connect(String conString, int delay) {
        try {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                // Wait a bit for db to start
                Thread.sleep(delay);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://" + conString
                        + "/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " + i);
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect() {
        if (con != null) {
            try {
                // Close connection
                con.close();
            } catch (SQLException e) {
                System.out.println("Error closing connection to database");
            }
        }
    }
}
