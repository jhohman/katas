package master.mind;

import static master.mind.Color.GREEN;
import static master.mind.Color.RED;
import static master.mind.Color.YELLOW;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import java.util.List;

import org.junit.Test;

public class CodeEvaluatorTest {
    @Test public void forOneCorrectPositionReturn_10() {
        List<Color> code = List.of(RED, YELLOW, YELLOW, YELLOW);
        List<Color> guess = List.of(RED, GREEN, GREEN, GREEN);
        CodeEvaluator codeEvaluator = new CodeEvaluator(code);

        int[] result = codeEvaluator.evaluate(guess);

        assertThat(result, is(new int[]{1,0}));
    }

    @Test public void forOneMisplacedPositionReturn_01() {
        List<Color> code = List.of(RED, YELLOW, YELLOW, YELLOW);
        List<Color> guess = List.of(GREEN, RED, GREEN, GREEN);
        CodeEvaluator codeEvaluator = new CodeEvaluator(code);

        int[] result = codeEvaluator.evaluate(guess);

        assertThat(result, is(new int[]{0,1}));
    }
}