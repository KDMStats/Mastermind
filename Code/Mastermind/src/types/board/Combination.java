package types.board;

import java.util.ArrayList;
import java.util.List;

import logs.LogHandler;
import types.tokens.Token;

public class Combination {

	private List<Token> tokens;

	public Combination(List<Token> tokens) {
		if (tokens.size() != 4) {
			LogHandler.getInstance().crash("Tried to set Combination with "
					+ tokens.size() + " Tokens! " + tokens);
		}
		this.tokens = new ArrayList<>(tokens);
	}

	public List<Token> getTokens() {
		return tokens;
	}

	public void setTokens(List<Token> tokens) {
		this.tokens = tokens;
	}

	@Override
	public String toString() {
		return tokens.toString();
	}

	public boolean containsTokenAtIndex(Token token, Integer index) {
		return tokens.get(index).equals(token);
	}

	public boolean containsTokenAtAnyIndex(Token token) {
		return tokens.contains(token);
	}

}
