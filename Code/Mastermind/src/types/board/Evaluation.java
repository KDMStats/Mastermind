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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + redPin;
		result = prime * result + yellowPin;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evaluation other = (Evaluation) obj;
		if (redPin != other.redPin)
			return false;
		if (yellowPin != other.yellowPin)
			return false;
		return true;
	}
}
