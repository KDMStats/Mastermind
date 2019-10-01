package controller.playerModules;

import logs.LogHandler;
import types.board.Board;
import types.board.Combination;

public abstract class APlayerModule {

	public Combination formulateGuess(Board board) {
		Combination combo = formulateGuessInternal(board);
		LogHandler.getInstance().addLog("Guess: " + combo);
		return combo;
	}

	protected abstract Combination formulateGuessInternal(Board board);

	public abstract void initialise();

}
