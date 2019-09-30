package types.board;

import java.util.HashMap;
import java.util.Map;

import logs.LogHandler;

public class Board {

	private int turn;
	private int turnLimit;

	private Map<Integer, Combination> combinations = new HashMap<>();
	private Map<Integer, Evaluation> evaluations = new HashMap<>();

	public Board(int turnLimit) {
		this.turn = 1;
		this.turnLimit = turnLimit;
		System.out.println("Turn " + turn + "/" + turnLimit);
	}

	public boolean isFinalTurn() {
		return turn == turnLimit;
	}

	public void nextTurn() {
		if (turn == turnLimit) {
			LogHandler.getInstance()
					.crash("Trying to increment Turn, already Turn 10");
		}
		this.turn++;
		System.out.println("Turn " + turn + "/" + turnLimit);
	}

	public void addNextCombination(Combination combination,
			Evaluation evaluation) {
		if (combination == null) {
			LogHandler.getInstance()
					.crash("Trying to set a null combination onto the board");
		}
		if (evaluation == null) {
			LogHandler.getInstance()
					.crash("Trying to set a null evaluation onto the board");
		}
		combinations.put(turn, combination);
		evaluations.put(turn, evaluation);
	}

}
