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
		LogHandler.getInstance().addLog("Turn " + turn + "/" + turnLimit);
	}

	public int getTurnCount() {
		return turn;
	}

	public void nextTurn() {
		if (turn == turnLimit) {
			LogHandler.getInstance()
					.crash("Trying to increment Turn, already Turn 10");
		}
		this.turn++;
		LogHandler.getInstance().addLog("Turn " + turn + "/" + turnLimit);
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

	public Combination getLastGuess() {
		if (!combinations.containsKey(turn - 1)) {
			LogHandler.getInstance()
					.crash("Cannot find Combination for last turn");
		}
		return combinations.get(turn - 1);
	}

	public Evaluation getLastEvaluation() {
		if (!evaluations.containsKey(turn - 1)) {
			LogHandler.getInstance()
					.crash("Cannot find Evaluation for last turn");
		}
		return evaluations.get(turn - 1);
	}

}
