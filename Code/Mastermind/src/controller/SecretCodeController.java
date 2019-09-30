package controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import types.board.Combination;
import types.board.Evaluation;
import types.tokens.Token;

public class SecretCodeController {

	private Combination secretCode;
	private Map<Integer, Token> secretCodeMap = new HashMap<>();

	public SecretCodeController(Combination secretCode) {
		this.secretCode = secretCode;
		for (int i = 0; i < 4; i++) {
			this.secretCodeMap.put(i, secretCode.getTokens().get(i));
		}
	}

	public Evaluation evaluateCombination(Combination combination) {
		int redPinCount = 0;
		int yellowPinCount = 0;

		for (Entry<Integer, Token> entry : secretCodeMap.entrySet()) {
			if (combination.containsTokenAtIndex(entry.getValue(),
					entry.getKey())) {
				redPinCount++;
			} else if (combination.containsTokenAtAnyIndex(entry.getValue())) {
				yellowPinCount++;
			}
		}

		return new Evaluation(redPinCount, yellowPinCount);
	}
}
