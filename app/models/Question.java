package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Question extends Model {
	@Id
	@GeneratedValue
	public long questionId;
	@OneToOne(mappedBy = "subject")
	@JoinColumn(name = "subjectId")
	public long subjectId;
	public QuestionStatus questionStatus;
	@Required
	@Column(nullable = false)
	public String orientation;
	public QuestionType questionType;

	public Question(long subjectId, QuestionStatus questionStatus,
			String orientation, QuestionType questionType) {
		this.subjectId = subjectId;
		this.questionStatus = questionStatus;
		this.orientation = orientation;
		this.questionType = questionType;
	}

	public static Finder<Long, Question> find = new Finder<Long, Question>(
			Long.class, Question.class);
}
