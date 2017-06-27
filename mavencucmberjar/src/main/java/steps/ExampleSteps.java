package steps;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@ContextConfiguration("/cucumber.xml")
public class ExampleSteps {
	private static final Logger log = LoggerFactory.getLogger(ExampleSteps.class);
	
	@Before
	public void before() throws InterruptedException, IOException {
		
		WebDriver driver = new RemoteWebDriver( new URL("http://192.168.0.100:4444/wd/hub"),  DesiredCapabilities.chrome());
		//Capabilities actualCapabilities = ((RemoteWebDriver) driver).getCapabilities();
		driver.get("http://www.google.com/xhtml");
		Thread.sleep(100); // Let the user actually see something!
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("Sandli matharoo");
		searchBox.submit();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//h3[@class='r']/a)[1]")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Sign in")).click();

		driver.findElement(By.id("session_key-login")).sendKeys("it@gmail.com");
		driver.findElement(By.id("session_password-login")).sendKeys("abcd");
		driver.findElement(By.name("signin")).click();
		Thread.sleep(500);
		// driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();

	}

	@After
	public void after() {
		// driver.quit();
	}

	@Given("^prospective user with email \"([^\"]*)\" pre-exists$")
	public void prospective_user_with_email_pre_exists(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(true);
	}

	@Given("^email \"([^\"]*)\" is not pre-registered$")
	public void email_is_not_pre_registered(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(true);
	}

	@When("^user submits add \"([^\"]*)\" form$")
	public void user_submits_add_form(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(true);
	}

	@Then("^email \"([^\"]*)\" is registered$")
	public void email_is_registered(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(true);
	}

	@Given("^email \"([^\"]*)\" is pre-registered$")
	public void email_is_pre_registered(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(true);
	}

	@Then("^duplicate email \"([^\"]*)\" error is thrown$")
	public void duplicate_email_error_is_thrown(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(true);
	}

}
