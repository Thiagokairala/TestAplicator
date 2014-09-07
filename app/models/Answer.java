package models;

import javax.annotation.Nullable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import play.db.ebean.Model;

@Entity
public class Answer extends Model {
	@Id
	@GeneratedValue
	public long answerId;
	@ManyToOne
	@JoinColumn(name = "questionId")
	public long questionId;
	@Column(nullable = false)
	public String answerText;
	@Column(nullable = false)
	public boolean isCorrect;

	public Answer(final String answerText) {
		this.answerText = answerText;
	}

	public static Finder<Long, Answer> find = new Finder<Long, Answer>(
			Long.class, Answer.class);

}
