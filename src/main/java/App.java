import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class App {
    private Connection con = null;

    public void connect(String conString, int delay) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                Thread.sleep(delay);
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

    public void disconnect() {
        if (con != null) {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }

    public List<String> getCountriesByPopulation() {
        List<String> result = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            String sql = "SELECT name, population FROM country ORDER BY population DESC";
            ResultSet rset = stmt.executeQuery(sql);
            while (rset.next()) {
                String name = rset.getString("name");
                int population = rset.getInt("population");
                result.add(name + "\t" + population);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }
        return result;
    }

    public List<String> getRegionsByTotalPopulation() {
        List<String> result = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            String sql = "SELECT region, SUM(population) AS total_population " +
                    "FROM country " +
                    "GROUP BY region " +
                    "ORDER BY total_population DESC";
            ResultSet rset = stmt.executeQuery(sql);
            while (rset.next()) {
                String region = rset.getString("region");
                int totalPopulation = rset.getInt("total_population");
                result.add(region + "\t" + totalPopulation);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }
        return result;



    }

    public List<String> getContinentsByPopulation() {
        List<String> result = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            String sql = "SELECT continent, SUM(population) AS total_population " +
                    "FROM country " +
                    "GROUP BY continent " +
                    "ORDER BY total_population DESC";
            ResultSet rset = stmt.executeQuery(sql);
            while (rset.next()) {
                String continent = rset.getString("continent");
                long totalPopulation = rset.getLong("total_population");
                result.add(continent + "\t" + totalPopulation);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }
        return result;
    }

    public long getCountryPopulation(String countryName) {
        long population = -1; // Default value in case of failure
        try {
            Statement stmt = con.createStatement();
            String sql = "SELECT population FROM country WHERE name = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, countryName);
            ResultSet rset = pstmt.executeQuery();
            if (rset.next()) {
                population = rset.getLong("population");
            } else {
                System.out.println("Country not found in the database.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country population.");
        }
        return population;
    }

    public long getCityPopulation(String cityName) {
        long population = -1; // Default value for invalid city or failure
        try {
            Statement stmt = con.createStatement();
            String sql = "SELECT population FROM city WHERE name = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, cityName);
            ResultSet rset = pstmt.executeQuery();
            if (rset.next()) {
                population = rset.getLong("population");
            } else {
                System.out.println("City not found in the database.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city population.");
        }
        return population;
    }

    public List<String> getCitiesOrderedByPopulation() {
        List<String> citiesList = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            String sql = "SELECT name, population FROM city ORDER BY population DESC";
            ResultSet rset = stmt.executeQuery(sql);

            while (rset.next()) {
                String cityName = rset.getString("name");
                long population = rset.getLong("population");
                citiesList.add(cityName + "\t" + population);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities ordered by population.");
        }
        return citiesList;
    }



}