import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AppIntegrationTest {
    static App app;

    @BeforeAll
    static void init() {
        app = new App();
        app.connect("localhost:33060", 0);
    }

    @Test
    void testGetCountriesByPopulation() {
        List<String> result = app.getCountriesByPopulation();
        assertNotNull(result, "The result should not be null.");
        assertFalse(result.isEmpty(), "The result should not be empty.");
        System.out.println("Countries by population: ");
        result.forEach(System.out::println);

        // Example assertion (ensure first country is the one with the largest population)
        String firstResult = result.get(0);
        assertTrue(firstResult.contains("China"), "The first country should be China based on population.");
    }

    @Test
    void testGetRegionsByTotalPopulation() {
        List<String> result = app.getRegionsByTotalPopulation();
        assertNotNull(result, "The result should not be null.");
        assertFalse(result.isEmpty(), "The result should not be empty.");
        System.out.println("Regions by total population: ");
        result.forEach(System.out::println);

        // Example assertion (ensure data is sorted correctly)
        String firstRegion = result.get(0);
        assertTrue(firstRegion.contains("Asia"), "The first region should be Asia based on total population.");


    }

    @Test
    void testGetContinentsByPopulation() {
        List<String> result = app.getContinentsByPopulation();
        assertNotNull(result, "The result should not be null.");
        assertFalse(result.isEmpty(), "The result should not be empty.");
        System.out.println("Continents by population: ");
        result.forEach(System.out::println);

        // Example assertion: Check that Asia is the first continent in the list
        String firstResult = result.get(0);
        assertTrue(firstResult.contains("Asia"), "The first continent should be Asia based on population.");
    }

    @Test
    void testGetCountryPopulation() {
        String countryName = "Brazil"; // Replace with an existing country in your database
        long population = app.getCountryPopulation(countryName);
        assertTrue(population > 0, "The population should be greater than 0 for a valid country.");
        System.out.println("Population of " + countryName + ": " + population);

        // Test for a non-existent country
        String invalidCountry = "Atlantis";
        long invalidPopulation = app.getCountryPopulation(invalidCountry);
        assertEquals(-1, invalidPopulation, "For an invalid country, the population should return -1.");
    }

    @Test
    void testGetCityPopulation() {
        String cityName = "São Paulo"; // Replace with an existing city in your database
        long population = app.getCityPopulation(cityName);
        assertTrue(population > 0, "The population should be greater than 0 for a valid city.");
        System.out.println("Population of " + cityName + ": " + population);

        // Test for a non-existent city
        String invalidCity = "Atlantis";
        long invalidPopulation = app.getCityPopulation(invalidCity);
        assertEquals(-1, invalidPopulation, "For an invalid city, the population should return -1.");
    }

    @Test
    void testGetCitiesOrderedByPopulation() {
        // Fetch the list of cities ordered by population
        List<String> citiesList = app.getCitiesOrderedByPopulation();

        // Check if the list is not empty
        assertFalse(citiesList.isEmpty(), "The list of cities should not be empty.");

        // Print the cities for manual verification
        citiesList.forEach(System.out::println);

        // Verify the first city has the largest population (this is an example check, adjust as needed)
        String firstCity = citiesList.get(0);
        String[] firstCityDetails = firstCity.split("\t");
        long firstCityPopulation = Long.parseLong(firstCityDetails[1]);
        assertTrue(firstCityPopulation > 0, "The largest city should have a population greater than 0.");

        // Optionally, you can add more checks to ensure the list is correctly ordered
        // For example, you could check that the population of cities decreases as the list progresses.
        for (int i = 1; i < citiesList.size(); i++) {
            String previousCity = citiesList.get(i - 1);
            String currentCity = citiesList.get(i);

            long previousPopulation = Long.parseLong(previousCity.split("\t")[1]);
            long currentPopulation = Long.parseLong(currentCity.split("\t")[1]);

            assertTrue(previousPopulation >= currentPopulation,
                    "The population of cities should be ordered from largest to smallest.");
        }
    }



}