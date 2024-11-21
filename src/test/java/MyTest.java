import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


class MyTest
{
    @Test
    public void unitTest() throws Exception
    {
        System.out.println("hello world");
        String[] args = null;

        assertEquals(0,App.hello());
    }
}