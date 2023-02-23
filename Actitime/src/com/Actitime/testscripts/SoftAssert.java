package com.Actitime.testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SoftAssert {
	public void demoassertion() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		   String expectedtitle = "soogle";
		   String Actualtitle = driver.getTitle();
		   SoftAssert s=new SoftAssert();
		   s.
}
}