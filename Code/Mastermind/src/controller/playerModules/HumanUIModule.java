package controller.playerModules;

import java.util.Scanner;

import types.board.Board;
import types.board.Combination;
import utils.CodeUtils;

public class HumanUIModule extends APlayerModule {

	private static Scanner scanner = new Scanner(System.in);

	// RED, YELLOW, GREEN, ORANGE, PINK, PURPLE, BLUE, WHITE
	// r y g o p u b w
	@Override
	protected Combination formulateGuessInternal(Board board) {
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
			combo = CodeUtils.parseUserInput(inputString);
			if (combo == null) {
				System.out.println("Invalid Input");
				continue;
			}
			break;
		}
		return combo;
	}

	@Override
	public void initialise() {
		// TODO Auto-generated method stub

	}

}
