package com.abc.tests;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.GivenWhenThen.then;
import static net.serenitybdd.screenplay.GivenWhenThen.when;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.thucydides.core.annotations.Managed;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.abc.model.Category;
import com.abc.tasks.NavigateToMotors;


@RunWith(SerenityRunner.class)
public class WhenBrowingProductCategories {

	@Managed
	WebDriver browser;
	
	Actor mike = Actor.named("Mike");
	
	@Test
	public void shouldBeAbleToViewMotorProducts() {
		mike.can(BrowseTheWeb.with(browser));
		when(mike).attemptsTo(NavigateToMotors.theCategory(Category.Motors));
		then(mike).should(seeThat(TheWebPage.title(), CoreMatchers.containsString("New & used cars, trucks, motorcycles, parts, accessories – eBay Motors")));
	}

	@Test
	public void shouldBeAbleToViewFashionProducts() {
		mike.can(BrowseTheWeb.with(browser));
		when(mike).attemptsTo(NavigateToMotors.theCategory(Category.Fashion));
		then(mike).should(seeThat(TheWebPage.title(), CoreMatchers.containsString("Fashion - Mens, Womens, Kids, Baby, Clothing, Dresses | eBay")));
	}
	
	@Test
	public void shouldBeAbleToViewVehiclesUnderMotorProducts() {
		mike.can(BrowseTheWeb.with(browser));
		when(mike).attemptsTo(NavigateToMotors.theCategory(Category.Motors, "Vehicles"));
		then(mike).should(seeThat(TheWebPage.title(), CoreMatchers.containsString("Vehicles for Sale – Buy New & Used Vehicles Online | eBay")));
	}
	
	@Test
	public void shouldBeAbleToViewPowerSportsUnderMotorProducts() {
		mike.can(BrowseTheWeb.with(browser));
		when(mike).attemptsTo(NavigateToMotors.theCategory(Category.POWERSPORTS, "Motors - Powersports"));
		then(mike).should(seeThat(TheWebPage.title(), CoreMatchers.containsString("Powersports Vehicles – Buy New & Used ATVs, Jet Skis & More  | eBay")));
	}	
}
