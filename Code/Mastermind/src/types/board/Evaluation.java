package types.board;

public class Evaluation {

	private int redPin;
	private int yellowPin;

	public Evaluation(int redPin, int yellowPin) {
		super();
		this.yellowPin = yellowPin;
		this.redPin = redPin;
	}

	public int getRedPin() {
		return redPin;
	}

	public void setRedPin(int redPin) {
		this.redPin = redPin;
	}

	public int getYellowPin() {
		return yellowPin;
	}

	public void setYellowPin(int yellowPin) {
		this.yellowPin = yellowPin;
	}

	@Override
	public String toString() {
		return "Evaluation [redPin=" + redPin + ", yellowPin=" + yellowPin
				+ "]";
	}
}
