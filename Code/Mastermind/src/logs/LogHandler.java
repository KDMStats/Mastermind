package logs;

import java.util.ArrayList;
import java.util.List;

public class LogHandler {

	private static LogHandler instance;

	private boolean printLogs = false;

	private List<Log> allLogs = new ArrayList<>();

	public static LogHandler getInstance() {
		if (instance == null) {
			instance = new LogHandler();
		}
		return instance;
	}

	private LogHandler() {
	}

	public void setPrintLogs(boolean printLogs) {
		this.printLogs = printLogs;
	}

	public void addLog(String message) {
		if (printLogs) {
			System.out.println(message);
		}
		allLogs.add(new Log(message));
	}

	public void clearLogs() {
		allLogs.clear();
	}

	public void crash(String message) {
		for (Log log : allLogs) {
			System.out.println(log);
		}
		System.out.println(message);
		System.exit(1);
	}

}
