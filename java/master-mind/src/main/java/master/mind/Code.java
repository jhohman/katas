package master.mind;

import static java.util.stream.Collectors.toList;

import java.util.List;

public class Code {
    private List<Color> colors;

    public Code(List<Color> colors) {
        this.colors = colors;
    }

    public static Code create(String code) {
        List<Color> colors = code.chars().mapToObj(c -> Color.fromSymbol("" + (char)c)).collect(toList());
        return new Code(colors);
    }

    public int[] evaluateGuess(Code guess) {
        CodeEvaluator code = new CodeEvaluator(this.colors);
        return code.evaluate(guess.colors);
    }

    public boolean equals(Object other) {
        if(this == other) return true;

        if (!(other instanceof Code)) return false;

        Code otherColors = (Code)other;
        for (int i=0; i<colors.size(); i++) {
            if (!(colors.get(i) == otherColors.colors.get(i))) return false;    
        }
        return true;
    }

    @Override
    public int hashCode() {
        return colors.hashCode();
    }
}