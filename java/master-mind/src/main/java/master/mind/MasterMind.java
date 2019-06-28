package master.mind;

public class MasterMind {
    private Code code;

	public MasterMind(String secret) {
        this.code = Code.create(secret);
	}

	public int[] guess(String guess) {
        Code codeGuess = Code.create(guess);

		return this.code.evaluateGuess(codeGuess);
	}
}