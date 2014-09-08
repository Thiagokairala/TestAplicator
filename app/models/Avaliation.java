package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import play.db.ebean.Model;
import types.Subject;
import enums.Mention;

@Entity
public class Avaliation extends Model {

	@Id
	@GeneratedValue
	public long avaliationId;

	@Column(nullable = false)
	public Subject subject;

	@ManyToMany(cascade = CascadeType.ALL)
	public List<Question> questions;

	public Mention mention;

	public int grade;
}
