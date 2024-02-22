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

    @Test
public void testValidISBN10WithHyphens() {
    ISBN testISBN = new ISBN("0-321-14653-0");
    Assertions.assertTrue(testISBN.isValid());
}

@Test
public void testValidISBN10WithSpaces() {
    ISBN testISBN = new ISBN("0 321 14653 0");
    Assertions.assertTrue(testISBN.isValid());
}

@Test
public void testInvalidISBN10WithInvalidCheckDigit() {
    ISBN testISBN = new ISBN("0136291555");
    Assertions.assertFalse(testISBN.isValid());
}

@Test
public void testInvalidISBN10WithLetters() {
    ISBN testISBN = new ISBN("0X36291554");
    Assertions.assertFalse(testISBN.isValid());
}

@Test
public void testValidISBN13WithSpaces() {
    ISBN testISBN = new ISBN("978 0 306 40615 7");
    Assertions.assertTrue(testISBN.isValid());
}

@Test
public void testValidISBN13WithoutHyphens() {
    ISBN testISBN = new ISBN("9780306406157");
    Assertions.assertTrue(testISBN.isValid());
}

@Test
public void testInvalidISBN13WithInvalidCheckDigit() {
    ISBN testISBN = new ISBN("978-0-306-40615-6");
    Assertions.assertFalse(testISBN.isValid());
}

@Test
public void testInvalidISBN13TooShort() {
    ISBN testISBN = new ISBN("978-0-306-4061");
    Assertions.assertFalse(testISBN.isValid());
}

@Test
public void testInvalidISBN13TooLong() {
    ISBN testISBN = new ISBN("978-0-306-40615-78");
    Assertions.assertFalse(testISBN.isValid());
}

@Test
public void testInvalidISBN10AllZeros() {
    ISBN testISBN = new ISBN("0000000000");
    Assertions.assertFalse(testISBN.isValid());
}

@Test
public void testValidISBN10EndingWithX() {
    ISBN testISBN = new ISBN("012000030X");
    Assertions.assertTrue(testISBN.isValid());
}

@Test
public void testInvalidISBN10EndingWithXButInvalid() {
    ISBN testISBN = new ISBN("0120000300");
    Assertions.assertFalse(testISBN.isValid());
}

@Test
public void testISBN10WithInvalidCharacters() {
    ISBN testISBN = new ISBN("01A6291554");
    Assertions.assertFalse(testISBN.isValid());
}

@Test
public void testISBN13WithInvalidCharacters() {
    ISBN testISBN = new ISBN("978-0-306-4O615-7");
    Assertions.assertFalse(testISBN.isValid());
}

@Test
public void testValidISBN13WithHyphens() {
    ISBN testISBN = new ISBN("978-3-16-148410-0");
    Assertions.assertTrue(testISBN.isValid());
}

@Test
public void testValidISBN13AllZerosInMiddle() {
    ISBN testISBN = new ISBN("978-0-00-000000-2");
    Assertions.assertTrue(testISBN.isValid());
}

@Test
public void testInvalidISBN10TooShort() {
    ISBN testISBN = new ISBN("123456789");
    Assertions.assertFalse(testISBN.isValid());
}

@Test
public void testInvalidISBN10TooLong() {
    ISBN testISBN = new ISBN("12345678901");
    Assertions.assertFalse(testISBN.isValid());
}

@Test
public void testInvalidISBN13TooShort() {
    ISBN testISBN = new ISBN("97803064061");
    Assertions.assertFalse(testISBN.isValid());
}

@Test
public void testInvalidISBN13TooLong() {
    ISBN testISBN = new ISBN("97803064061570");
    Assertions.assertFalse(testISBN.isValid());
}

@Test
public void testInvalidISBN13InvalidPrefix() {
    ISBN testISBN = new ISBN("979-0-306-40615-7");
    Assertions.assertFalse(testISBN.isValid());
}
}