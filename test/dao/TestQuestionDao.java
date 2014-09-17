package dao;

import static org.fest.assertions.Assertions.assertThat;

import java.util.List;

import models.Question;

import org.junit.Before;
import org.junit.Test;

import play.Logger;
import enums.QuestionLevel;
import enums.QuestionStatus;
import enums.QuestionType;
import exceptions.InvalidNumberOfQuestions;
import types.Subject;
import TestHelper.TestBaseClass;

public class TestQuestionDao extends TestBaseClass {

	@Before
	public void setUp() {
		this.insertEasyQuestions();
		this.insertMediumQuestions();
	}

	@Test
	public void testGetQuestionsByLevelQuantity() throws Exception {

		int howMany = 5;

		List<Question> questions = QuestionDao.getQuestionsByLevel(
				QuestionLevel.EASY, howMany);

		assertThat(questions.size()).isEqualTo(howMany);

		Logger.info("GetQuestionsByLevelQuantity - runned");
	}

	@Test
	public void testGetQuestionsByLevelQuestionsDiferent() throws Exception {
		int howMany = 5;

		List<Question> questions = QuestionDao.getQuestionsByLevel(
				QuestionLevel.EASY, howMany);

		for (int i = 0; i < howMany; i++) {
			for (int j = 0; j < howMany; j++) {
				if (i != j) {
					long firstId = questions.get(i).questionId;
					long seccondId = questions.get(j).questionId;

					assertThat(firstId).isNotEqualTo(seccondId);
				}
			}
		}

		Logger.info("GetQuestionsByLevelQuestionsDiferent - runned");
	}

	@Test(expected = InvalidNumberOfQuestions.class)
	public void testGetQuestionsByLevelNegativeHowMany() throws Exception {
		int howMany = -1;

		Logger.info("GetQuestionsByLevelNegativeHowMany - runned");
		@SuppressWarnings("unused")
		List<Question> questions = QuestionDao.getQuestionsByLevel(
				QuestionLevel.EASY, howMany);

	}

	/******************************************************************************************
	 * Private tests methods.
	 ******************************************************************************************/
	private void insertEasyQuestions() {
		for (int i = 0; i < 10; i++) {
			Question Question = new Question(new Subject("teste"),
					QuestionStatus.CORRECT, "teste",
					QuestionType.MULTIPLE_QUESTION, QuestionLevel.EASY);
			Question.save();
		}
	}

	private void insertMediumQuestions() {
		for (int i = 0; i < 10; i++) {
			Question Question = new Question(new Subject("teste"),
					QuestionStatus.CORRECT, "teste",
					QuestionType.MULTIPLE_QUESTION, QuestionLevel.MEDIUM);
			Question.save();
		}
	}
}
