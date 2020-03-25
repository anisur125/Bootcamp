package ExpediaTestNG;

import org.testng.annotations.Test;

import ExpediaTestPage.ExContinuePage;
import ExpediaTestPage.ExHomePage;
import ExpediaTestPage.ExReturnPage;
import ExpediaTestPage.ExSelectionPage;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class ExpediaBooking {
	public static WebDriver driver;
	public static String parentHandle;
	
  @Test (priority = 1)
  public void booking_page() {
	  ExHomePage obj_home = new ExHomePage(driver);
	  obj_home.flight_button();
	  obj_home.departure_loc_field("Baltimore");
	  obj_home.arrival_loc_field("Chicago");
	  obj_home.departure_date();
	  obj_home.arrival_date_op();
	  obj_home.search();
	  parentHandle = driver.getWindowHandle();
	  driver.switchTo().window(parentHandle);
  }
  @Test(priority = 2)
  public void selection_page() {
	  //parentHandle = driver.getWindowHandle();
	  ExSelectionPage obj_select = new ExSelectionPage(driver);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  obj_select.dep_selection_field();
	  //driver.switchTo().window(parentHandle);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  obj_select.dep_selection_button();
	  driver.switchTo().window(parentHandle);
  }
  @Test(priority = 3)
  public void return_selection_page()  {
	  String parentHandle = driver.getWindowHandle();
	  ExReturnPage obj_return_select = new ExReturnPage(driver);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  obj_return_select.return_selection_field();
	  driver.switchTo().window(parentHandle);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  obj_return_select.return_selection_button();
  }
  
  @Test(priority = 4)
  public void continue_page() {
	  
	  ExContinuePage obj_continue = new ExContinuePage(driver);
	  obj_continue.continue_button();

  }
  
  
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Anis\\eclipse-workspace\\FuntionalGroup\\Driver\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("https://www.expedia.com/");
  }

  @AfterClass
  public void afterClass() {
  }

}
