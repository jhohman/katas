package master.mind;

import static java.util.stream.Collectors.toList;

import java.util.List;

public class Code {
    public static List<Color> interpret(String code) {
        return code.chars().mapToObj(c -> Color.fromSymbol("" + (char)c)).collect(toList());
    }
}