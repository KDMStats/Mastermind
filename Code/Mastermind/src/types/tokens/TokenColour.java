package types.tokens;

public enum TokenColour {
	RED("r"), YELLOW("y"), GREEN("g"), ORANGE("o"), PINK("p"), PURPLE("u"),
	BLUE("b"), WHITE("w");

	private String id;

	private TokenColour(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public static TokenColour parseId(String id) {
		for (TokenColour tk : TokenColour.values()) {
			if (tk.getId().equalsIgnoreCase(id)) {
				return tk;
			}
		}
		return null;
	}
}
