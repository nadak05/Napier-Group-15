import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


class MyTest
{
    @Test
    public void unitTest() throws Exception
    {

        assertEquals(0,App.hello());
    }
}