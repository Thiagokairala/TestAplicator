package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class MultipleQuestion extends Question {

	public List<Answer> answers;

	public MultipleQuestion(final long subjectId,
			final QuestionStatus questionStatus, final String orientation) {
		super(subjectId, questionStatus, orientation,
				QuestionType.MULTIPLE_QUESTION);
	}
}
