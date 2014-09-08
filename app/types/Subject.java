package types;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
public class Subject extends Model {

	@Id
	@GeneratedValue
	public long subjectId;

	@Column(nullable = false)
	public String subject;

	public Subject(final String subject) {
		this.subject = subject;
	}

	public static Finder<Long, Subject> find = new Finder<Long, Subject>(
			Long.class, Subject.class);
}
