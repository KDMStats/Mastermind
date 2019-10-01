package controller;

import controller.playerModules.APlayerModule;
import types.board.Board;
import types.board.Combination;

public class PlayerController {

	APlayerModule playerModule;

	public PlayerController(APlayerModule playerModule) {
		this.playerModule = playerModule;
	}

	public Combination formulateGuess(Board board) {
		return playerModule.formulateGuess(board);
	}

}
