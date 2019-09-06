package roman.numerals;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RomanNumeralTest {

    public RomanNumeralCalculator calculator = new RomanNumeralCalculator();
    @Test public void MMXIX_Returns_2019() {
        RomanNumeralParser parser = new RomanNumeralParser();
        RomanNumeral numeral = new RomanNumeral(parser, calculator);

        // RomanNumeralCalculatorMock
        
        int result = numeral.toArabic("MMXIX");
        //[M, M, X, IX]
        //[M, D, C, L, X, V, I]
        //[CM, XC, XL, IX, IV]

        // MMXIX -> MMX [IX]

        assertEquals(result, 2019);
    }

    @Test public void MMXVIII_Returns_2018() {
        RomanNumeralParser parser = new RomanNumeralParser();
        RomanNumeral numeral = new RomanNumeral(parser, calculator);
        
        int result = numeral.toArabic("MMXVIII");

        assertEquals(result, 2018);
    }
}