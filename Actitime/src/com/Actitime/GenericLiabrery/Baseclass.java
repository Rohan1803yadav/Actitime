package com.Actitime.GenericLiabrery;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Actitime.pom.Homepage;
import com.Actitime.pom.LoginPage;

public class Baseclass {
	FileLiabrary f=new FileLiabrary();
	
	public static WebDriver driver;
	@BeforeSuite
	public void databaseconnection() {
		Reporter.log("database connected",true);
	}
	@AfterSuite
	public void databasedisconnection() {
		Reporter.log("database disconnected",true);
	}
	
	@BeforeClass
	public void launchBrowser() throws IOException {
    driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	String url = f.readDataFromPropertyFile("url");
	driver.get("https://demo.actitime.com");
	Reporter.log("browser launched successfully",true);
		
	
	}
	@AfterClass
	public void closebrowser() {
		driver.close();
		Reporter.log("browser closed successfully",true);
	}
	
	@BeforeMethod
	public void loginToActitime() throws IOException {
		String un = f.readDataFromPropertyFile("username");
		String pw = f.readDataFromPropertyFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.login(un, pw);
		Reporter.log("logged in successfully",true);
		
	}
	
	@AfterMethod
	public void logoutFromActitime() throws InterruptedException {
		Homepage hp=new Homepage(driver);
		Thread.sleep(2000);
		hp.getLogoutlnk().click();
		//driver.findElement(By.id("logoutLink")).click();
		Reporter.log("logged out successfully",true);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
