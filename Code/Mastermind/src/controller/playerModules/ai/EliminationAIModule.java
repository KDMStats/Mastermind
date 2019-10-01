package controller.playerModules.ai;

import java.util.ArrayList;
import java.util.List;

import controller.playerModules.APlayerModule;
import logs.LogHandler;
import types.board.Board;
import types.board.Combination;
import types.board.Evaluation;
import types.tokens.Token;
import types.tokens.TokenColour;
import utils.CodeUtils;

public class EliminationAIModule extends APlayerModule {

	List<Combination> defaultViableSecretCodes = new ArrayList<>();
	List<Combination> viableSecretCodes = new ArrayList<>();

	public EliminationAIModule() {
		defaultViableSecretCodes = getNextTokenForCombo(new ArrayList<>());
	}

	@Override
	public void initialise() {
		viableSecretCodes = new ArrayList<>(defaultViableSecretCodes);
	}

	private List<Combination> getNextTokenForCombo(List<Token> tokens) {
		List<Combination> allCombos = new ArrayList<>();

		// If we have 4 tokens, then finished
		if (tokens.size() == 4) {
			allCombos.add(new Combination(tokens));
			return allCombos;
		}

		// Add all possible token colours for each non-duplicated new value to
		// the existing incomplete combination
		for (TokenColour tkc : TokenColour.values()) {
			Token newToken = new Token(tkc);
			if (tokens.contains(newToken)) {
				continue;
			}
			List<Token> newList = new ArrayList<>();
			newList.addAll(tokens);
			newList.add(newToken);
			allCombos.addAll(getNextTokenForCombo(newList));
		}
		return allCombos;
	}

	@Override
	protected Combination formulateGuessInternal(Board board) {
		if (board.getTurnCount() == 1) {
			return CodeUtils.parseUserInput("rbgy");
		}

		reduceGuesses(board);

		return determineNextGuess();
	}

	private void reduceGuesses(Board board) {
		int oldGuessSize = viableSecretCodes.size();

		List<Combination> badSecretCodes = new ArrayList<>();

		Combination lastGuess = board.getLastGuess();
		Evaluation lastEval = board.getLastEvaluation();

		for (Combination secretCode : viableSecretCodes) {
			Evaluation eval = CodeUtils.evaluateCombination(secretCode,
					lastGuess);
			if (!eval.equals(lastEval)) {
				badSecretCodes.add(secretCode);
			}
		}
		viableSecretCodes.removeAll(badSecretCodes);

		int newGuessSize = viableSecretCodes.size();
		LogHandler.getInstance().addLog("Reduced Viable Secret Codes from "
				+ oldGuessSize + " to " + newGuessSize);
	}

	private Combination determineNextGuess() {
		if (viableSecretCodes.isEmpty()) {
			LogHandler.getInstance().crash("No more Viable Secret Codes!");
		}
		return viableSecretCodes.get(0);
	}

}
