package com.abc.ui;

import net.serenitybdd.screenplay.targets.Target;

public class FirstResult {
	
	public static Target theFirstResult(String searchTerm) {
		return Target.the("query: " + searchTerm)
				.locatedBy(".//*[@id='rso']/div/div[1]/div/h3/a[1]");
	}
}
