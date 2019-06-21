package master.mind;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CodeBreaker {
    private List<Color> code;
    
    public CodeBreaker(List<Color> code) {
        this.code = code;    
    }

    public int[] breakCode(List<Color> guess) {
        int wellPlacedCount = calculateWellPlaced(guess);
        int colorCount = calculateColorCount(guess);

        return new int[]{wellPlacedCount, colorCount};
    }

    private int calculateWellPlaced(List<Color> guess) {
        int count = 0;
        for (int i=0; i < guess.size(); i++) {
            if (code.get(i).equals (guess.get(i))) {
                count++;
            } 
        } 
        return count;
    }

    private int calculateColorCount(List<Color> guess) {
        List<Color> codeCopy = removeMatches(guess, code);
        List<Color> guessCopy = removeMatches(code, guess);
        Map<Color, List<Color>> codeCounts = codeCopy.stream().collect(Collectors.groupingBy(color -> color));
        Map<Color, List<Color>> guessCounts = guessCopy.stream().collect(Collectors.groupingBy(color -> color));

        int count = 0;
        for(Color color : guessCounts.keySet()) {
            int min = findMinCount(guessCounts.get(color), codeCounts.get(color), color);
            count += min;
        }
        return count;
    }

    private List<Color> removeMatches(List<Color> source, List<Color> targetCopy) {
        List<Color> codes = new ArrayList<>();
        for (int i=0; i < source.size(); i++) {
            if (!targetCopy.get(i).equals (source.get(i))) {
             codes.add(targetCopy.get(i));
            } 
        }
        return codes;
    }

    private int findMinCount(List<Color> guess, List<Color> codes, Color key) {
        if(codes == null) return 0;
        return Math.min(guess.size(), codes.size());
    }
}