package master.mind;

import java.util.HashMap;
import java.util.Map;

public enum Color {
    RED("R"),
    GREEN("G"),
    YELLOW("Y"),
    BLUE("B");

    private String symbol;
    private static Map<String, Color> symbolToColor = new HashMap<>();

    static {
        for (Color c: Color.values()) {
            symbolToColor.put(c.symbol, c);
        }
    }

    private Color(String symbol) {
        this.symbol = symbol;
    }

    public static Color fromSymbol(String symbol) {
        return symbolToColor.get(symbol);
    }


}