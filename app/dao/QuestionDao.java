package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import enums.QuestionLevel;
import exceptions.InvalidNumberOfQuestions;
import models.Question;
import models.Question;

public class QuestionDao {
	public static List<Question> getQuestionsByLevel(
			final QuestionLevel level, final int howMany)
			throws InvalidNumberOfQuestions {
		if (howMany > 0) {
			List<Question> questions = getAllByLevel(level);

			questions = getOnlyThree(howMany, questions);

			return questions;
		} else {
			throw new InvalidNumberOfQuestions();
		}
	}

	private static List<Question> getOnlyThree(final int howMany,
			List<Question> questions) {
		List<Question> smallerList = new ArrayList<Question>();
		Random random = new Random();

		for (int i = 0; i < howMany; i++) {
			int randomIndex = random.nextInt(questions.size());
			smallerList.add(questions.get(randomIndex));
			questions.remove(randomIndex);
		}

		return smallerList;
	}

	private static List<Question> getAllByLevel(
			final QuestionLevel level) {
		List<Question> questions = Question.find.where()
				.eq("question_level", level).findList();
		return questions;
	}
}
