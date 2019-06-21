package master.mind;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

/**
 * Computer: RRRR Guess: GGGG Output: [0,0]
 *
 * Computer: RRRR Guess: RGGG Output: [1,0]
 *
 * Computer: RGYB Guess: RGBB Output: [3,0]
 **/

public class MasterMindTest {
    @Test public void guessNoneRightReturnsZeros() {
        MasterMind masterMind = new MasterMind("RRRR");

        int[] result = masterMind.guess("GGGG");

        assertThat(result, is(new int[]{0,0}));
    }

    @Test public void guessWithFirstPositionCorrectReturns10() {
        MasterMind masterMind = new MasterMind("RRBR");

        int[] result = masterMind.guess("RGGB");

        assertThat(result, is(new int[]{1,1}));
    }

    @Test public void guessWithAllPositionsCorrectReturn40() {
        MasterMind masterMind = new MasterMind("RGYB");

        int[] result = masterMind.guess("RGYB");

        assertThat(result, is(new int[]{4,0}));
    }
}