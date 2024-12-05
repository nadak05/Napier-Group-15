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

        a.report1();
        a.report2();

        // Disconnect from database
        a.disconnect();
    }

    public void report1() throws IOException {
        StringBuilder sb = new StringBuilder();
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement to get name and population ordered by population descending
            String sql = "SELECT name, population FROM country ORDER BY population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(sql);
            // Cycle through result set and build output
            while (rset.next()) {
                String name = rset.getString("name");
                int population = rset.getInt("population");
                sb.append(name + "\t" + population + "\r\n");
            }
            // Create output directory if not exists
            new File("./output/").mkdir();
            // Write the result to a file
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(new File("./output/report.txt")));
            writer.write(sb.toString());
            writer.close();
            System.out.println(sb.toString()); // Print output to console
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
            return;
        }

        System.out.println(sb.toString()); // Print output to console
    }

    public void report2() throws IOException {
        StringBuilder sb = new StringBuilder();
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String sql = "SELECT region, SUM(population) AS total_population " +
                    "FROM country " +
                    "GROUP BY region " +
                    "ORDER BY total_population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(sql);
            //cycle
            while (rset.next()) {
                String region = rset.getString("region");
                Integer totalPopulation = rset.getInt("total_population");
                sb.append(region + "\t" + totalPopulation + "\r\n");
            }
            new File("./output/").mkdir();
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(new File("./output/report2.txt")));
            writer.write(sb.toString());
            writer.close();
            System.out.println(sb.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
            return;
        }

        System.out.println(sb.toString());
    }

    /**
     * Connect to the MySQL database.
     *
     * @param conString
     * 		Use db:3306 for docker and localhost:33060 for local or Integration
     * 		Tests TEST
     * @param
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
                //Added allowPublicKeyRetrieval=true to get Integration Tests
                // to work. Possibly due to accessing from another class?
                con = DriverManager.getConnection("jdbc:mysql://" + conString
                        + "/world?allowPublicKeyRetrieval=true&useSSL"
                        + "=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt "
                        + Integer.toString(i));
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
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }
}