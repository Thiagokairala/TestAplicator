package models;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import types.Subject;
import enums.QuestionLevel;
import enums.QuestionStatus;
import enums.QuestionType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class RightOrWrongQuestion extends Question {

	public String text;
	public boolean answer;

	public RightOrWrongQuestion(final Subject subject,
			final QuestionStatus questionStatus, final String orientation,
			final boolean answer, final QuestionLevel questionLevel) {

		super(subject, questionStatus, orientation,
				QuestionType.RIGHT_OR_WRONG_QUESTION, questionLevel);
	}

	public static Finder<Long, RightOrWrongQuestion> find = new Finder<Long, RightOrWrongQuestion>(
			Long.class, RightOrWrongQuestion.class);
}
