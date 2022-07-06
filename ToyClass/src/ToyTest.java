import static org.junit.Assert.*;

public class ToyTest {

    @org.junit.Test
    public void testToyConstructor() {
        Toy test = new Toy("Woody",9.99);
        assertEquals("Woody", test.getName());
        assertEquals(9.99, test.getPrice(),.001);
    }
}