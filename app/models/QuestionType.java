package models;

public enum QuestionType {
	MULTIPLE_QUESTION(0), RIGHT_OR_WRONG_QUESTION(1), OPEN_TEXT_QUESTION(2);

	public int questionType;

	private QuestionType(int questionType) {
		this.questionType = questionType;
	}
}
