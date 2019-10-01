package controller;

import types.board.Combination;
import types.board.Evaluation;
import utils.CodeUtils;

public class SecretCodeController {

	private Combination secretCode;

	public SecretCodeController(Combination secretCode) {
		this.secretCode = secretCode;
	}

	public Evaluation evaluateCombination(Combination guess) {
		return CodeUtils.evaluateCombination(secretCode, guess);
	}

}
