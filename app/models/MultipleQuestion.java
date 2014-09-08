package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

import types.MultipleQuestionAnswer;
import types.Subject;
import enums.QuestionStatus;
import enums.QuestionType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class MultipleQuestion extends Question {

	@ManyToOne(cascade = CascadeType.ALL)
	public List<MultipleQuestionAnswer> answers;

	public MultipleQuestion(final Subject subject,
			final QuestionStatus questionStatus, final String orientation) {
		super(subject, questionStatus, orientation,
				QuestionType.MULTIPLE_QUESTION);
	}

	public static Finder<Long, MultipleQuestion> find = new Finder<Long, MultipleQuestion>(
			Long.class, MultipleQuestion.class);

}
