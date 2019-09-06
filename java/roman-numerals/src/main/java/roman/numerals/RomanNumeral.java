package roman.numerals;

public class RomanNumeral {

    private RomanNumeralCalculator calculator;
    private RomanNumeralParser parser;
    
    public RomanNumeral(RomanNumeralParser parser, RomanNumeralCalculator calculator) {
        this.calculator = calculator;
        this.parser = parser;
    }

    public int toArabic(String numeral) {
        RomanNumeralTokens tokens = parser.parse(numeral);
        return tokens.calculate(calculator);
    }
}