package com.abc.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import com.abc.ui.FirstResult;

public class OpenSearchResult implements Task {

	String searchTerm;
	
	public OpenSearchResult(String searchTerm) {
		this.searchTerm = searchTerm;
	}
	
	@Override
	public <T extends Actor> void performAs(T actor) {
		// TODO Auto-generated method stub
        actor.attemptsTo(
        	Click.on(FirstResult.theFirstResult(searchTerm))
        );
	}

    public static OpenSearchResult forTheFirstPage(String searchTerm) {
        return instrumented(OpenSearchResult.class, searchTerm);
    }  	
}
