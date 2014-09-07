package dao;

import static org.fest.assertions.Assertions.assertThat;

import java.util.List;

import models.Question;
import models.QuestionStatus;
import models.QuestionType;

import org.junit.Test;

import TestHelper.TestBaseClass;

public class TestQuestionDao extends TestBaseClass {

	private String orientation = "This is the question orientation";
	private Question question = new Question(0, QuestionStatus.CORRECT,
			orientation, QuestionType.MULTIPLE_QUESTION);

	@Test
	public void testSaveQuestion() {
		QuestionDao.saveQuestion(question);

		assertThat(question.questionId).isGreaterThan(0);
	}

	@Test
	public void testDeleteQuestionById() {
		QuestionDao.saveQuestion(question);

		QuestionDao.deleteQuestionById(question.questionId);

		Question.find.byId(question.questionId);
	}

	@Test
	public void testUpdateQuestion() {
		QuestionDao.saveQuestion(question);
		String newOrientation = "This is the new orientation";

		question.orientation = newOrientation;

		QuestionDao.updateQuestion(question);

		assertThat(question.orientation).isEqualTo(newOrientation);
	}

	@Test
	public void testGetAllQuestions() {
		for (int i = 0; i < 10; i++) {
			Question newQuestion = new Question(1, QuestionStatus.CORRECT,
					orientation, QuestionType.MULTIPLE_QUESTION);
			QuestionDao.saveQuestion(newQuestion);
		}

		List<Question> questions = QuestionDao.getAllQuestions();

		assertThat(questions.size()).isEqualTo(10);
	}

}
