package run;

import java.util.HashMap;
import java.util.Map;

import controller.GameController;
import controller.playerModules.APlayerModule;
import controller.playerModules.ai.EliminationAIModule;
import logs.LogHandler;
import types.board.Combination;
import utils.CodeUtils;

public class MastermindRun {

	public static final int TURN_LIMIT = 10;

	public static final int SERIES_COUNT = 10;
	public static final int RUN_COUNT = 100;

	public MastermindRun() {
		LogHandler.getInstance().setPrintLogs(false);

		// APlayerModule pModule = new HumanUIModule();
		// APlayerModule pModule = new StupidAIModule();
		APlayerModule pModule = new EliminationAIModule();

		int gameCount = 0;
		int winCount = 0;
		double totalWinTurns = 0;

		Map<Integer, Integer> turnCounts = new HashMap<>();

		for (int series = 0; series < SERIES_COUNT; series++) {
			for (int run = 0; run < RUN_COUNT; run++) {

				pModule.initialise();

				Combination secretCode = CodeUtils
						.generateRandomCombination(false);
				GameController controller = new GameController(secretCode,
						pModule);
				int winTurns = controller.run();
				if (winTurns > 0) {
					LogHandler.getInstance().addLog("Win!");
					winCount++;
					totalWinTurns += winTurns;
					if (!turnCounts.containsKey(winTurns)) {
						turnCounts.put(winTurns, 0);
					}
					turnCounts.put(winTurns, turnCounts.get(winTurns) + 1);
				} else {
					LogHandler.getInstance().addLog("Lose!");
				}
				gameCount++;
				LogHandler.getInstance().clearLogs();
			}
			System.out.println(
					"Ran " + gameCount + "/" + (SERIES_COUNT * RUN_COUNT));
		}

		double winTurnsAverage = totalWinTurns / (winCount * 1.0);
		double winPercent = (winCount * 1.0 / gameCount) * 100.0;

		System.out.println("Won " + winCount + "/" + gameCount + " games!");
		System.out.println("Win Rate: " + winPercent + "%");
		System.out.println("Average Turns to Win: " + winTurnsAverage);
		System.out.println("Win Turns Breakdown: " + turnCounts);

	}

	public static void main(String[] args) {
		new MastermindRun();
	}

}
