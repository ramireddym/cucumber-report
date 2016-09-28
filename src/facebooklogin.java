import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class facebooklogin {
	WebDriver driver;
	@Before
	@Given("^browser as \"([^\"]*)\" And URL as \"([^\"]*)\"$")
	public void browser_as_And_URL_as(String browser, String url) throws Throwable {
		if(browser.equals("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(browser.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "D:\\Venkata Rami Reddy\\testing softwares\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","D:\\Venkata Rami Reddy\\testing softwares\\chromedriver.exe");
			driver=new ChromeDriver();	 
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

	}

	@When("^user logs in using Username  And Password$")
	public void user_logs_in_using_Username_And_Password(DataTable usercredentials) throws Throwable {
		List<List<String>> data = usercredentials.raw();
		WebElement ele=driver.findElement(By.id("email"));
		ele.clear();
		ele.sendKeys(data.get(0).get(0));
		WebElement ele1=driver.findElement(By.id("pass"));
		ele1.clear();
		ele1.sendKeys(data.get(0).get(1));
		driver.findElement(By.id("loginbutton")).click();


		//driver.navigate().to("https://www.facebook.com/");
		WebElement ele2=driver.findElement(By.id("email"));
		ele2.clear();
		ele2.sendKeys(data.get(1).get(0));
		WebElement ele3=driver.findElement(By.id("pass"));
		//ele3.clear();
		ele3.sendKeys(data.get(1).get(1));
		driver.findElement(By.id("loginbutton")).click();
		Assert.assertEquals(driver.getTitle(), "Facebook");

	}

	@Then("^login should be successful$")
	public void login_should_be_successful() throws Throwable {
		System.out.println("login successfully");

	}
	@After
	public void quite()
	{
		driver.quit();
	}
}
