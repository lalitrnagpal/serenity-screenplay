package com.abc.test;

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
public class GetFirstResultOfSearchForDarkKnight {

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
	 public void search_results_should_show_the_search_term_in_the_title() {
	 	givenThat(anna).wasAbleTo(openTheApplication);
	 	when(anna).attemptsTo(Search.forTheTerm("firestorm"));
	 	when(anna).attemptsTo(OpenSearchResult.forTheFirstPage("firestorm"));
	 	then(anna).should(eventually(seeThat(TheWebPage.title(),
	    containsString("Firestorm (comics) - Wikipedia"))));
	 }

}
