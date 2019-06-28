package master.mind;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ColorMapper {
    public List<Color> guess;
    public List<Color> secret;

    public ColorMapper(List<Color> guess, List<Color> secret) {
        this.guess = guess;
        this.secret = secret;
    }

    public Map<Color, List<Color>> sumUnmatchedCode() {
        return countColors(this.guess, this.secret);
    }

    public Map<Color, List<Color>> sumUnmatchedSecret() {
        return countColors(this.secret, this.guess);
    }

    private Map<Color, List<Color>> countColors(List<Color> source, List<Color> target) {
        List<Color> sourceMinusTarget = removeMatches(source, target);
        return sourceMinusTarget.stream().collect(Collectors.groupingBy(color -> color));
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
}