package master.mind;

import java.util.List;
import java.util.Map;

public class MisplacedCodeEvaluator {
    public int evaluate(List<Color> secret, List<Color> guess) {
        ColorMapper colorMapper = new ColorMapper(guess, secret);
        Map<Color, List<Color>> codeCounts = colorMapper.sumUnmatchedCode();
        Map<Color, List<Color>> guessCounts = colorMapper.sumUnmatchedSecret();

        return sumMinimumColorCounts(codeCounts, guessCounts);
    }

    private int sumMinimumColorCounts(Map<Color, List<Color>> codeCounts, Map<Color, List<Color>> guessCounts) {
        int count = 0;
        for(Color color : guessCounts.keySet()) {
            int min = findMinCount(guessCounts.get(color), codeCounts.get(color), color);
            count += min;
        }
        return count;
    }

    private int findMinCount(List<Color> guess, List<Color> codes, Color key) {
        if(codes == null) return 0;
        return Math.min(guess.size(), codes.size());
    }
}