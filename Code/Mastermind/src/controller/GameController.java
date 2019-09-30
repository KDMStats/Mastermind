package controller;

import java.util.Scanner;

import run.MastermindRun;
import types.board.Board;
import types.board.Combination;
import types.board.Evaluation;
import utils.SecretCodeUtils;

public class GameController {

	private static Scanner scanner = new Scanner(System.in);

	private Board board;

	private SecretCodeController secretCodeController;

	public GameController(Combination secretCode) {
		System.out.println("Secret Code: " + secretCode);
		this.board = new Board(MastermindRun.TURN_LIMIT);
		this.secretCodeController = new SecretCodeController(secretCode);
	}

	public boolean run() {
		while (true) {
			// Make Guess
			Combination turnGuess = getGuessInput();

			// Check Guess
			Evaluation evaluation = secretCodeController
					.evaluateCombination(turnGuess);
			System.out.println("Evaluation: " + evaluation);

			if (evaluation.getRedPin() == 4) {
				return true;
			}
			board.addNextCombination(turnGuess, evaluation);

			if (board.isFinalTurn()) {
				return false;
			}
			board.nextTurn();
		}
	}

	// RED, YELLOW, GREEN, ORANGE, PINK, PURPLE, BLUE, WHITE
	// r y g o p u b w
	private Combination getGuessInput() {
		String inputString = "";
		Combination combo = null;

		while (true) {
			System.out.println("r y g o p u b w");
			System.out.print(": ");
			inputString = scanner.nextLine();
			if (inputString.length() != 4) {
				System.out.println("Invalid Input");
				continue;
			}
			combo = SecretCodeUtils.parseUserInput(inputString);
			if (combo == null) {
				System.out.println("Invalid Input");
				continue;
			}
			break;
		}
		return combo;
	}

}
