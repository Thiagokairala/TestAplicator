package models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import types.Subject;
import enums.QuestionLevel;
import enums.QuestionStatus;
import enums.QuestionType;

@Entity
public class Question extends Model {

	@Id
	@GeneratedValue
	public long questionId;

	@OneToMany(cascade = CascadeType.ALL)
	public Subject subject;

	public QuestionStatus questionStatus;

	@Required
	@Column(nullable = false)
	public String orientation;

	public QuestionType questionType;
	public QuestionLevel questionLevel;

	public Question(Subject subject, QuestionStatus questionStatus,
			String orientation, QuestionType questionType,
			QuestionLevel questionLevel) {
		this.subject = subject;
		this.questionStatus = questionStatus;
		this.orientation = orientation;
		this.questionType = questionType;
		this.questionLevel = questionLevel;
	}

	public static Finder<Long, Question> find = new Finder<Long, Question>(
			Long.class, Question.class);
}
