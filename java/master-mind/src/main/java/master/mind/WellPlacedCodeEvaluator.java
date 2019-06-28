package master.mind;

import java.util.List;

public class WellPlacedCodeEvaluator {

    public int evaluate(List<Color> secret, List<Color> guess) {
        int count = 0;
        for (int i=0; i < guess.size(); i++) {
            if (secret.get(i).equals (guess.get(i))) {
                count++;
            } 
        } 
        return count;
    }
}
