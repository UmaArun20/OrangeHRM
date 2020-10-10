

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OrangeHRM_login_convert_TestNG   {

	@Test

	public void Login() throws InterruptedException
	{
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Anandhan\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		//driver.findElement(By.name("txtUsername")).sendKeys("Admin");
        driver.findElementByName("txtUsername").sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		String Element = driver.findElement(By.linkText("Dashboard")).getText();
		System.out.println(Element);
		driver.findElementById("welcome").click();
		Thread.sleep(5000);
		driver.findElementByLinkText("Logout").click();
		driver.close();//Close will close only current chrome browser

	}

}
