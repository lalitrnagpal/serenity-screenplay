package com.abc.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

import com.abc.model.Category;
import com.abc.model.SubCategory;
import com.abc.pageobjects.EBayHomePage;
import com.abc.ui.NavigationBar;

public class NavigateToMotors implements Task {
	
	private Category category;
	private String title;
	
	private EBayHomePage theEbayHomePage;

	public NavigateToMotors(Category category) {
		this.category = category;
	}

	public NavigateToMotors(Category category, String title) {
		this.category = category;
		this.title = title;
	}
	
	@Override
	@Step("{0} navigates to the #category category")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
				Open.browserOn(theEbayHomePage),  
				Click.on(NavigationBar.category(category))
			);
		if (null != title) {
			actor.attemptsTo(
					Click.on(NavigationBar.subCategory(title))
			);
		}
	}

	public static Performable theCategory(Category category) {
		return Instrumented.instanceOf(NavigateToMotors.class).withProperties(category);
	}

	public static Performable theCategory(Category category, String title) {
		return Instrumented.instanceOf(NavigateToMotors.class).withProperties(category, title);
	}

}
