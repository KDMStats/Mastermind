package types.tokens;

public class Token {

	private TokenColour colour;

	public Token(TokenColour colour) {
		this.colour = colour;
	}

	public TokenColour getColour() {
		return colour;
	}

	public void setColour(TokenColour colour) {
		this.colour = colour;
	}

	@Override
	public String toString() {
		return colour.getId();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((colour == null) ? 0 : colour.hashCode());
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
		Token other = (Token) obj;
		if (colour != other.colour)
			return false;
		return true;
	}
}
