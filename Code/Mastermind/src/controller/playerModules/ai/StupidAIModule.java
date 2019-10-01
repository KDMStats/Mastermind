package controller.playerModules.ai;

import controller.playerModules.APlayerModule;
import types.board.Board;
import types.board.Combination;
import utils.CodeUtils;

public class StupidAIModule extends APlayerModule {

	@Override
	protected Combination formulateGuessInternal(Board board) {
		return CodeUtils.generateRandomCombination(false);
	}

	@Override
	public void initialise() {
		// TODO Auto-generated method stub

	}

}
