package com.abc.ui;

import net.serenitybdd.screenplay.targets.Target;

import com.abc.model.Category;
import com.abc.model.SubCategory;

public class NavigationBar {

	public static Target category(Category category) {
		return Target.the(category.name() + " category")
				.locatedBy("//td[@class='cat']/a[contains(text(), '{0}')]")
				.of(category.name());
	}
	
	public static Target subCategory(String title) {
		return Target.the(title + " subCategory")
				.locatedBy("//div[@class='sub-cats']//a[@title='Motors - Powersports']")
				.of(title);
	}
}
