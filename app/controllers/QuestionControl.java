package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import play.*;
import play.i18n.Messages;
import play.mvc.*;
import views.html.*;

public class QuestionControl extends Controller {
	public static Result registerQuestion() {
		return TODO;
	}

	public static Result findTypeOfQuestion() {
		return ok(findQuestionType.render());
	}

}
