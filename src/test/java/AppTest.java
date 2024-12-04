import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


public class AppTest {

    @Test
    public void testReportGeneration() {
        App app = new App();
        app.connect("localhost:33060", 0);

        // Generate report
        String report = app.report1();

        // Perform assertions (assuming some data is in the database)
        assertTrue(report.contains("China"));
        assertTrue(report.contains("India"));

        app.disconnect();
    }
}