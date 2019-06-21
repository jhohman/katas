package master.mind;

import java.util.List;

public class MasterMind {
    private List<Color> code;
    private CodeBreaker codeBreaker;

	public MasterMind(String secret) {
        this.code = Code.interpret(secret);
        this.codeBreaker = new CodeBreaker(this.code);
	}

	public int[] guess(String guess) {
        List<Color> codeGuess = Code.interpret(guess);

		return codeBreaker.breakCode(codeGuess);
	}

}