package StepDefinations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SauceDemoSteps {
	
	WebDriver driver=null;
	WebDriverWait wait = null;

	@Given("user open a browser")
	public void user_open_a_browser() {
	   System.setProperty("webdriver.chrome.driver", "C:/Users/DAX/git/SwagLab/Cucumberjava/src/test/resources/drivers/chromedriver.exe");
	   driver=new ChromeDriver();
	   wait = new WebDriverWait(driver, 10);
	}

	@Given("user is on saucedemo page")
	public void user_is_on_saucedemo_page() throws InterruptedException {
	  driver.navigate().to("https://www.saucedemo.com/");
	  Thread.sleep(3000);
	  
	}

	@When("user enter username and password field")
	public void user_enter_username_and_password_field() throws InterruptedException {
	   driver.findElement(By.id("user-name")).sendKeys("standard_user");
	   driver.findElement(By.id("password")).sendKeys("secret_sauce");
	   Thread.sleep(3000);
	}

	@And("Hit Login Button")
	public void Hit_Login_Button() throws InterruptedException {
	   driver.findElement(By.id("login-button")).click();
	   Thread.sleep(3000);
	}

	@Then("User navigate to Homepage")
	public void user_navigate_to_Homepage() {
		driver.getPageSource().contains("Products");
		
	   
	}
	@Then("Select Filters Options")
	public void Select_Filters_Options() throws InterruptedException {
		WebElement dropdown=driver.findElement(By.className("product_sort_container"));
		Select selectobject=new Select(dropdown);
		selectobject.selectByVisibleText("Price (high to low)");
		Thread.sleep(3000);
	   
	}
	@Then("Adding product to the cart")
	public void adding_product_to_the_cart() throws InterruptedException {
	    
	    WebElement AddingProduct=driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
	    AddingProduct.click();
	    Thread.sleep(3000);
	    JavascriptExecutor up = (JavascriptExecutor) driver;
        up.executeScript("window.scrollBy(0, -500);");
        Thread.sleep(3000);
        JavascriptExecutor down = (JavascriptExecutor) driver;
        down.executeScript("window.scrollBy(0, 500);");
        WebElement RemoveProduct=driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt"));
        RemoveProduct.click();
        driver.quit();
	}
}
