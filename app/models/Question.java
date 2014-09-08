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
import enums.QuestionStatus;
import enums.QuestionType;

@Entity
public abstract class Question extends Model {

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

	public Question(Subject subject, QuestionStatus questionStatus,
			String orientation, QuestionType questionType) {
		this.subject = subject;
		this.questionStatus = questionStatus;
		this.orientation = orientation;
		this.questionType = questionType;
	}

	public static Finder<Long, Question> find = new Finder<Long, Question>(
			Long.class, Question.class);
}
