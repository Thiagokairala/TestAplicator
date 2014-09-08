package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import models.MultipleQuestion;
import enums.QuestionLevel;

public class MultipleQuestionDao {

	public List<MultipleQuestion> getMultipleQuestionsByLevel(
			final QuestionLevel level, final int howMany) {

		assert (howMany > 0);
		List<MultipleQuestion> questions = MultipleQuestion.find.all();

		MultipleQuestion[] questionsArray = (MultipleQuestion[]) questions
				.toArray();

		Random random = new Random();
		List<MultipleQuestion> listToReturn = new ArrayList<MultipleQuestion>();

		ArrayList<Integer> alreadyChosen = new ArrayList<Integer>();

		for (int i = 0; i < howMany; i++) {
			int randomIndex;
			do {
				randomIndex = random.nextInt(questionsArray.length);
			} while (this.checkIfWasUsed(randomIndex, alreadyChosen));

			alreadyChosen.add(randomIndex);

			listToReturn.add(questionsArray[randomIndex]);
		}

		return listToReturn;
	}

	private boolean checkIfWasUsed(int randomIndex, List<Integer> alreadyChosen) {
		boolean wasUsed = false;
		int size = alreadyChosen.size();

		for (int i = 0; i < size; i++) {
			if (alreadyChosen.get(i) == randomIndex) {
				wasUsed = true;
			}
		}
		return wasUsed;
	}
}
