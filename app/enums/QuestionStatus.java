package enums;

public enum QuestionStatus {
	CORRECT(true), INCORRECT(false);

	public boolean questionStatus;

	private QuestionStatus(boolean questionStatus) {
		this.questionStatus = questionStatus;
	}

}
