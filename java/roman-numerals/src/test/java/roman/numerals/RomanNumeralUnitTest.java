package roman.numerals;

import org.junit.*;
import org.mockito.junit.MockitoRule;
import org.mockito.junit.MockitoJUnit;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

public class RomanNumeralUnitTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock RomanNumeralCalculator calculator;

    @Mock RomanNumeralParser parser;

    @Mock RomanNumeralTokens tokens;

    @Test public void toArabicCallsRomanNumeralTokensCalculate() {
        when(parser.parse("I")).thenReturn(tokens);
        RomanNumeral numeral = new RomanNumeral(parser, calculator);

        numeral.toArabic("I");

        verify(tokens).calculate(calculator);
    }
}