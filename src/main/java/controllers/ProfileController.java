/*
 * ProfileController.java
 * 
 * Copyright (C) 2018 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the
 * TDG Licence, a copy of which you may download from
 * http://www.tdg-seville.info/License.html
 */

package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import forms.Calculator;

@Controller
@RequestMapping("/profile")
public class ProfileController extends AbstractController {

	// Action-1 ---------------------------------------------------------------		

	@RequestMapping(value = "/action-1", method = RequestMethod.GET)
	public ModelAndView action1() {
		ModelAndView result;
		List<String> quotes;
		quotes = new ArrayList<>();

		quotes.add("Make it simple, not simpler -- Albert Einstein");
		quotes.add("I have a dream -- Martin L. King");
		quotes.add("It always seem impossible until it's done -- Nelson Mandela");
		quotes.add("Cogito, ergo sum -- René Descartes");
		quotes.add("You know you are in love when you can't fall asleep because reality is finally better than your dreams -- Dr. Suess");
		quotes.add("Get busy living or get busy dying -- Stephen King");
		quotes.add("The first step toward success is taken when you refuse to be a captive of the environment in which you first find yourself -- Mark Caine");
		quotes.add("Those who dare to fail miserably can achieve greatly -- John F. Kennedy");
		quotes.add("It is hard to fail, but it is worse never to have tried to succeed -- Theodore Roosevelt");
		quotes.add("Love is a serious mental disease -- Plato");
		quotes.add("Only put off until tomorrow what you are willing to die having left undone -- Pablo Picasso");
		quotes.add("If you want to be happy, be -- Leo Tolstoy");
		quotes.add("Success is just a war of attrition. Sure, there is an element of talent you should probably possess. But if you just stick around long enough, eventually something is going to happen -- Dax Shepard");
		quotes.add("The opposite of love is not hate; it's indifference -- Elie Wiesel");
		quotes.add("Every great dream begins with a dreamer. Always remember, you have within you the strength, the patience, and the passion to reach for the stars to change the world -- Harriet Tubman");
		quotes.add("A friend is someone who gives you total freedom to be yourself -- Jim Morrison");
		quotes.add("Success in business requires training and discipline and hard work. But if you're not frightened by these things, the opportunities are just as great today as they ever were -- David Rockefeller");
		quotes.add("May you live all the days of your life -- Jonathan Swift");
		quotes.add("You're not obligated to win. You're obligated to keep trying. To the best you can do everyday -- Jason Mraz");
		quotes.add("Success? I don't know what that word means. I'm happy. But success, that goes back to what in somebody's eyes success means. For me, success is inner peace. That's a good day for me -- Denzel Washington");
		quotes.add("The dream crossed twilight between birth and dying -- T. S. Eliot");
		quotes.add("Creativity is just connecting things. When you ask creative people how they did something, they feel a little guilty because they didn't really do it, the just saw something. It seemed obvious to them after a while -- Steve Jobs");

		Collections.shuffle(quotes);
		quotes = quotes.subList(0, 3);

		result = new ModelAndView("profile/action-1");
		result.addObject("quotes", quotes);

		return result;
	}

	// Action-2 ---------------------------------------------------------------		

	@RequestMapping(value = "/action-2", method = RequestMethod.GET)
	public ModelAndView action2() {
		ModelAndView result;
		Calculator calculator;
		calculator = new Calculator();

		result = new ModelAndView("profile/action-2");
		result.addObject("calculator", calculator);

		return result;
	}

	@RequestMapping(value = "/action-2", method = RequestMethod.POST)
	public ModelAndView action2Post(@Valid final Calculator calculator, final BindingResult binding) {
		ModelAndView result;
		calculator.compute();

		result = new ModelAndView("profile/action-2");
		result.addObject("calculator", calculator);

		return result;
	}

	// Action-3 ---------------------------------------------------------------		

	@RequestMapping("/action-3")
	public ModelAndView action3() {
		throw new RuntimeException("Oops! An *expected* exception was thrown. This is normal behaviour.");
	}

}
