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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tokens == null) ? 0 : tokens.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Combination other = (Combination) obj;
		if (tokens == null) {
			if (other.tokens != null)
				return false;
		} else if (!tokens.equals(other.tokens))
			return false;
		return true;
	}

}
