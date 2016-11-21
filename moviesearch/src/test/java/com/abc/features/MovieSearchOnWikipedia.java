package com.abc.features;

import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.GivenWhenThen.then;
import static net.serenitybdd.screenplay.GivenWhenThen.when;
import static org.hamcrest.Matchers.containsString;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.abc.tasks.OpenSearchResult;
import com.abc.tasks.OpenTheApplication;
import com.abc.tasks.Search;

@RunWith(SerenityRunner.class)
public class MovieSearchOnWikipedia {

	 Actor anna = Actor.named("Anna"); 
	 
	 @Managed(uniqueSession = true)
	 public WebDriver herBrowser;
	 
	 @Steps
	 OpenTheApplication openTheApplication;
	 
	 @Before
	 public void annaCanBrowseTheWeb() {
	     anna.can(BrowseTheWeb.with(herBrowser));                                        
	 }   
	 
	 @Test
	 public void search_for_movie_the_dark_knight_on_wikipedia() {
	 	givenThat(anna).wasAbleTo(openTheApplication);
	 	when(anna).attemptsTo(Search.forTheTerm("The Dark Knight"));
	 	when(anna).attemptsTo(OpenSearchResult.forTheFirstPage("The Dark Knight"));
	 	then(anna).should(eventually(seeThat(TheWebPage.title(),
	    containsString("The Dark Knight (film) - Wikipedia"))));
	 }

	 @Test
	 public void search_for_movie_the_dark_knight_returns_on_wikipedia() {
	 	givenThat(anna).wasAbleTo(openTheApplication);
	 	when(anna).attemptsTo(Search.forTheTerm("The Dark Knight Returns"));
	 	when(anna).attemptsTo(OpenSearchResult.forTheFirstPage("Batman: The Dark Knight Returns (film) - Wikipedia"));
	 	then(anna).should(eventually(seeThat(TheWebPage.title(),
	    containsString("Batman: The Dark Knight Returns (film) - Wikipedia"))));
	 }
}
