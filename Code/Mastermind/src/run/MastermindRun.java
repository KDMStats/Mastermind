package run;

import controller.GameController;
import types.board.Combination;
import utils.SecretCodeUtils;

public class MastermindRun {

	public static final int TURN_LIMIT = 10;

	public MastermindRun() {

		Combination secretCode = SecretCodeUtils
				.generateRandomCombination(false);
		GameController controller = new GameController(secretCode);
		boolean win = controller.run();
		if (win) {
			System.out.println("Win!");
		} else {
			System.out.println("Lose!");
		}
	}

	public static void main(String[] args) {
		new MastermindRun();
	}

}
