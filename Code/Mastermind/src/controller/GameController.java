package controller;

import controller.playerModules.APlayerModule;
import logs.LogHandler;
import run.MastermindRun;
import types.board.Board;
import types.board.Combination;
import types.board.Evaluation;

public class GameController {

	private Board board;

	private SecretCodeController secretCodeController;

	private PlayerController playerController;

	public GameController(Combination secretCode, APlayerModule playerModule) {
		LogHandler.getInstance().addLog("Secret Code: " + secretCode);
		this.board = new Board(MastermindRun.TURN_LIMIT);
		this.secretCodeController = new SecretCodeController(secretCode);
		this.playerController = new PlayerController(playerModule);
	}

	public int run() {
		while (true) {
			// Make Guess
			Combination turnGuess = playerController.formulateGuess(board);

			// Check Guess
			Evaluation evaluation = secretCodeController
					.evaluateCombination(turnGuess);
			LogHandler.getInstance().addLog("Evaluation: " + evaluation);

			if (evaluation.getRedPin() == 4) {
				return board.getTurnCount();
			}
			board.addNextCombination(turnGuess, evaluation);

			if (board.getTurnCount() == MastermindRun.TURN_LIMIT) {
				return -1;
			}
			board.nextTurn();
		}
	}

}
