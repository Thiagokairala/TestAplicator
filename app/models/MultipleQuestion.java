package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

import types.MultipleQuestionAnswer;
import types.Subject;
import enums.QuestionLevel;
import enums.QuestionStatus;
import enums.QuestionType;

@Entity
public class MultipleQuestion extends Question {

	@ManyToOne(cascade = CascadeType.ALL)
	public List<MultipleQuestionAnswer> answers;

	/**
	 * 
	 * @param subject
	 * @param questionStatus
	 * @param orientation
	 * @param questionLevel
	 */
	public MultipleQuestion(final Subject subject,
			final QuestionStatus questionStatus, final String orientation,
			final QuestionLevel questionLevel) {
		super(subject, questionStatus, orientation,
				QuestionType.MULTIPLE_QUESTION, questionLevel);
	}

	public static Finder<Long, MultipleQuestion> find = new Finder<Long, MultipleQuestion>(
			Long.class, MultipleQuestion.class);

}
