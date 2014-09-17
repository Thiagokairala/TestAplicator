package enums;

public enum QuestionLevel {
	EASY(1), MEDIUM(2), HARD(3), VERY_HARD(4);

	public int level;

	private QuestionLevel(int level) {
		this.level = level;
	}
}
