package utils;

import java.util.ArrayList;
import java.util.List;

import types.board.Combination;
import types.board.Evaluation;
import types.tokens.Token;
import types.tokens.TokenColour;

public class CodeUtils {

	public static Combination generateRandomCombination(
			boolean allowDuplicateColours) {
		List<Token> tokens = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			int index = (int) (Math.random() * 8.0);
			Token token = new Token(TokenColour.values()[index]);
			if (tokens.contains(token) && !allowDuplicateColours) {
				i--;
				continue;
			}
			tokens.add(token);
		}
		return new Combination(tokens);
	}

	public static Combination parseUserInput(String inputString) {
		List<Token> tokens = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			String id = inputString.substring(i, i + 1);
			TokenColour tokenColour = TokenColour.parseId(id);
			if (tokenColour == null) {
				return null;
			}
			Token token = new Token(tokenColour);
			tokens.add(token);
		}

		return new Combination(tokens);
	}

	public static Evaluation evaluateCombination(Combination secretCode,
			Combination guess) {
		int redPinCount = 0;
		int yellowPinCount = 0;

		for (int index = 0; index < secretCode.getTokens().size(); index++) {
			Token token = secretCode.getTokens().get(index);
			if (guess.containsTokenAtIndex(token, index)) {
				redPinCount++;
			} else if (guess.containsTokenAtAnyIndex(token)) {
				yellowPinCount++;
			}
		}

		return new Evaluation(redPinCount, yellowPinCount);
	}

}
