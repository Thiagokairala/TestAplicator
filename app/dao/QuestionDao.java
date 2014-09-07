package dao;

import java.util.List;

import models.Question;

public class QuestionDao {
	public static void saveQuestion(final Question question) {
		question.save();
	}

	public static void deleteQuestionById(final long questionId) {
		Question question = Question.find.byId(questionId);
		question.delete();
	}

	public static void updateQuestion(Question question) {
		question.update();
	}

	public static List<Question> getAllQuestions() {
		List<Question> questions = Question.find.all();

		return questions;
	}
}
