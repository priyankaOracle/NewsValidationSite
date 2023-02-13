package com.jpmc.utilities;

import org.openqa.selenium.WebDriver;

public class NavigationUtils {
	
	public static void goToUrl(WebDriver driver, String url) {
		driver.navigate().to(url);
	}

}
