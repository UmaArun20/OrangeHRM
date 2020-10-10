import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRM_login_Before_After_Example   {

	ChromeDriver driver;
	
	@Before
	
	public void LaunchBrowser()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Anandhan\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}
	
	@After
	public void CloseBrowser()
	{
		
		driver.close();
	}
	
	@Test
	
	public void Login() throws InterruptedException
	{

		//driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElementByName("txtUsername").sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
		//to check whether this particular scenario done or not, dashboard is displayed or not.
		//driver.findElementByLinkText("Dashboard").isDisplayed();
		
		String ActDash= driver.findElementByLinkText("Dashboard").getText();
		System.out.println(ActDash);
		//verify url
		String ExpURL="https://opensource-demo.orangehrmlive.com/index.php/dashboard";
		String ActURL=driver.getCurrentUrl();
		Assert.assertEquals(ExpURL, ActURL);
		
		
		String ExpTitle= "OrangeHRM";
		String ActTitle= driver.getTitle();
		Assert.assertEquals(ExpTitle, ActTitle);
		
		
		String Element = driver.findElement(By.linkText("Dashboard")).getText();
		System.out.println(Element);
		driver.findElementById("welcome").click();
		Thread.sleep(5000);
		driver.findElementByLinkText("Logout").click();
		//driver.close();//Close will close only current chrome browser

	}

}
