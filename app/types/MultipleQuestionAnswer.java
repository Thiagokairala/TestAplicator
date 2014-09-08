package types;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import models.Question;
import play.db.ebean.Model;

@Entity
public class MultipleQuestionAnswer extends Model {
	@Id
	@GeneratedValue
	public long answerId;
	@ManyToOne(cascade = CascadeType.ALL)
	public Question question;
	@Column(nullable = false)
	public String answerText;
	@Column(nullable = false)
	public boolean isCorrect;

	public MultipleQuestionAnswer(final String answerText) {
		this.answerText = answerText;
	}

	public static Finder<Long, MultipleQuestionAnswer> find = new Finder<Long, MultipleQuestionAnswer>(
			Long.class, MultipleQuestionAnswer.class);

}
