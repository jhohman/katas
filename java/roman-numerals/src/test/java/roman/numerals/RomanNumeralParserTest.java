package roman.numerals;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class RomanNumeralParserTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock TwoCharacterParser twoCharacterParser;
    
    @Test
    public void parses2CharacterSymbols() {
        RomanNumeralParser parser = RomanNumeralParser(twoCharacterParser);
    }

}