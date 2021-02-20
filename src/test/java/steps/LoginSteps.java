package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class LoginSteps {

	WebDriver driver;

	@Given("I am in the login page")
	public void i_am_in_the_login_page() {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("ignore-certificate-errors");
		options.addArguments("--test-type");
		options.setAcceptInsecureCerts(true);
		// options.addArguments("--incognito");
		options.setHeadless(true);

		driver = new ChromeDriver(options);

		driver.get("http://zero.webappsecurity.com/");

	}

	@When("I enter valid credentials")
	public void i_enter_valid_credentials() {

		driver.findElement(By.id("signin_button")).click();
		driver.findElement(By.id("user_login")).sendKeys("username");
		driver.findElement(By.id("user_password")).sendKeys("password");
		driver.findElement(By.id("user_password")).submit();

	}

	@Then("I should be able to login successfully")
	public void i_should_be_able_to_login_successfully() {

		driver.findElement(By.linkText("Online Statements")).isDisplayed();
		driver.findElement(By.xpath("//*[@id=\"settingsBox\"]/ul/li[3]/a")).click();
		driver.findElement(By.id("logout_link")).click();

	}
	
	@When("I enter invalid {string} and {string}")
	public void i_enter_invalid_credentials(String username, String password) {
				
		driver.findElement(By.id("signin_button")).click();
		driver.findElement(By.id("user_login")).sendKeys(username);
		driver.findElement(By.id("user_password")).sendKeys(password);
		driver.findElement(By.id("user_password")).submit();
	   
	}

	@SuppressWarnings("deprecation")
	@Then("I should be able to see appropriate error message")
	public void i_should_be_able_to_see_appropriate_error_message() {
	    Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-error']")).getText().toString(),"Login and/or password are wrong.");
	}


}
