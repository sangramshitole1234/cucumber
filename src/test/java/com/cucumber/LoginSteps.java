package com.cucumber;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class LoginSteps 
{

	@When("^user opens \"(.*)\" browser$")
	public void openBrowser(String browsernm)
	{
		if(browsernm.equalsIgnoreCase("chrome"))
		{
			System.out.println("Chrome Browser");
			System.setProperty("webdriver.chrome.driver","D:\\Selenium\\29062019\\chromedriver.exe");
			Config.driver=new ChromeDriver();
			System.out.println("browser opened successfully");
			}
		else if (browsernm.equalsIgnoreCase("ie"))
		{
			System.out.println("Internet Explourer");
			System.setProperty("webdreiver.ie.driver","exe.path");
			Config.driver=new InternetExplorerDriver();
			System.out.println("browser open successfully");
		}
		else
		{
			System.out.println("firefox ");
			System.setProperty("webdriver.firefox.driver","exe.path");
			Config.driver=new FirefoxDriver();
		}
		
	}
	@And ("^user enters application url \"(.*)\"$")
	public void enterApplicationUrl(String url)
	{
		Config.driver.get(url);
		System.out.println("enter application url successfully");
	}
	@And("^user waits \"(.*)\" seconds to load login page$")
	public void waittillLoginpageloaded(int seconds)
	{
		Config.driver.manage().timeouts().pageLoadTimeout(seconds, TimeUnit.SECONDS);
		
	}
	@And("^user maximize the chrome browser$")
	public void maximizeBrowser()
	{
		Config.driver.manage().window().maximize();
	}
	@Then("^user is on login screen of Mercurry Tours application$")
	public void verifyLoginPage()
	{
		String act_title=Config.driver.getTitle();
		System.out.println("title of welcome Page :"+act_title);
		String exp_title="Welcome: Mercury Tours";
		Assert.assertEquals(exp_title, act_title);
	}
	@When("^user access login screen of Mercurry Tours application$")
	public void verifyLoginimg()
	{
		boolean act_flag=Config.driver.findElement(By.xpath("//img[@src='/images/featured_destination.gif']")).isDisplayed();
		System.out.println("ARUBA image is displayed"+act_flag);
		boolean exp_flag=true;
		Assert.assertEquals(exp_flag, act_flag);
	}
	@And("^user enters \"(.*)\" as username$")
	public void enterUsername(String username)
	{
		Config.driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(username);
	}
	@And("^user enters \"(.*)\" as password$")
	public void enetrPassword(String password)
	{
		Config.driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	}
	@And("^user clicks on Signin button$")
	public void clickonSignin()
	{
		Config.driver.findElement(By.xpath("//input[@name='login']")).click();
	}
	@Then ("^user is on flight finder Page$")
	public void verifyFlightFinderimg()
	{
		boolean act_flag1=Config.driver.findElement(By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']")).isDisplayed();
		System.out.println("Flight finder image is displayed: "+act_flag1);
		boolean exp_flag=true;
		Assert.assertEquals(exp_flag, act_flag1);
	}
	
	@When ("^user clicks on SignOff link$")
    public void clickonSignoff()
    {
    	Config.driver.findElement(By.linkText("SIGN-OFF")).click();
    }
	
	@Then ("^user is on sing in Screen$")
	public void verifySignOn()
	{
		boolean act_flag2=Config.driver.findElement(By.xpath("//img[@src='/images/masts/mast_signon.gif']")).isDisplayed();
		System.out.println("SignOn image is displayed: "+act_flag2);
		boolean exp_flag2=true;
		Assert.assertEquals(exp_flag2, act_flag2);
	}
	

}
