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
        Code code = Code.create("GGGG");

        assertThat(code, is(new Code(List.of(GREEN, GREEN, GREEN, GREEN))));
    }

    @Test
    public void YYYYReturnsListOf4Yellows() {
        Code code = Code.create("YYYY");

        assertThat(code, is(new Code(List.of(YELLOW, YELLOW, YELLOW, YELLOW))));
    }

    @Test public void RGYBReturnsListOfRedGreenYellowBlue() {
        Code code = Code.create("RGYB");

        assertThat(code, is(new Code(List.of(RED, GREEN, YELLOW, BLUE))));
    }
}