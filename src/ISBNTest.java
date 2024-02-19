import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class ISBNTest {

    @Test
    public void testValidISBN10() {
        ISBN testISBN = new ISBN("0136291554");
        Assertions.assertTrue(testISBN.isValid());
        
    }

    @Test
    public void testValidISBN13() {
        ISBN testISBN = new ISBN("978-0-306-40615-7");
        Assertions.assertTrue(testISBN.isValid());
    }

    @Test
    public void testInvalidISBN10() {
        ISBN testISBN = new ISBN("01-36291-555");
        Assertions.assertFalse(testISBN.isValid());
    }

    @Test
    public void testInvalidISBN13() {
        ISBN testISBN = new ISBN("978-0-306-40615-8");
        Assertions.assertFalse(testISBN.isValid());
    }
}