package master.mind;

import java.util.List;

public class CodeEvaluator {
    private List<Color> code;
    
    public CodeEvaluator(List<Color> code) {
        this.code = code;    
    }

    public int[] evaluate(List<Color> guess) {
        int wellPlacedCount = new WellPlacedCodeEvaluator().evaluate(code, guess);
        int misplacedCount = new MisplacedCodeEvaluator().evaluate(code, guess);
        return new int[]{wellPlacedCount, misplacedCount};
    }
}