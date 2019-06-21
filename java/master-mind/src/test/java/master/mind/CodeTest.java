package master.mind;

import java.util.List;

import org.junit.Test;

import static master.mind.Color.BLUE;
import static master.mind.Color.GREEN;
import static master.mind.Color.RED;
import static master.mind.Color.YELLOW;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CodeTest {
    @Test
    public void GGGGReturnsListOf4Greens() {
        List<Color> colors = Code.interpret("GGGG");

        assertThat(colors, is(List.of(GREEN, GREEN, GREEN, GREEN)));
    }

    @Test
    public void YYYYReturnsListOf4Yellows() {
        List<Color> colors = Code.interpret("YYYY");

        assertThat(colors, is(List.of(YELLOW, YELLOW, YELLOW, YELLOW)));
    }

    @Test public void RGYBReturnsListOfRedGreenYellowBlue() {
        List<Color> colors = Code.interpret("RGYB");

        assertThat(colors, is(List.of(RED, GREEN, YELLOW, BLUE)));
    }
}