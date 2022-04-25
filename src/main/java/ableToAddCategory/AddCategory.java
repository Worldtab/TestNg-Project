package ableToAddCategory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddCategory {

	static WebDriver driver;
	String browser;

	@BeforeClass
	public void readConfig() {

		Properties prop = new Properties();
		try {
			InputStream input = new FileInputStream("src\\main\\java\\config\\config.properties");
			prop.load(input);
			browser = prop.getProperty("browser");
			System.out.println("Browser used:" + browser);

		} catch (IOException e) {
			e.getStackTrace();
		}

	}

	@BeforeMethod
	public void init() {

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver", "driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.get("http://techfios.com/test/101/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test(priority = 1)
	public void AbletoAddCategory() throws InterruptedException {
		System.out.println(" Validate a user is able to add a category");
		By AbleToAddCategory = By.xpath("//body/div[4]/span[1]/input[1]");
		By ClickonAddButton = By.xpath("//body/div[4]/span[1]/input[2]");
		By ClickonSelectButton = By.xpath("//span[contains(text(),'Project2')]");

		driver.findElement(AbleToAddCategory).clear();
		Thread.sleep(2000);
		driver.findElement(AbleToAddCategory).sendKeys("Project2");
		Thread.sleep(2000);
		driver.findElement(ClickonAddButton).click();
		Thread.sleep(2000);
		driver.findElement(ClickonSelectButton).click();
		Thread.sleep(2000);

	}

	@Test(priority = 2)
	public void NotAbleToAddDuplicate() throws InterruptedException {

		System.out.println("Duplicated category name");
		By AbleToAddCategory = By.xpath("//body/div[4]/span[1]/input[1]");
		By ClickonAddButton = By.xpath("//body/div[4]/span[1]/input[2]");
		By ClickonSelectButton = By.xpath("//span[contains(text(),'Project2')]");

		driver.findElement(AbleToAddCategory).clear();
		Thread.sleep(3000);
		driver.findElement(AbleToAddCategory).sendKeys("Project2");
		Thread.sleep(3000);
		driver.findElement(ClickonAddButton).click();
		Thread.sleep(3000);
		driver.findElement(ClickonSelectButton).click();
		Thread.sleep(3000);

	}

	@Test(priority = 3)

	public void DueDateDropdown() throws InterruptedException {

		By ClickDueDateDropdown = By.xpath("//body/div[4]/span[1]/select[3]");
		By SelectDateJan = By.xpath("//option[contains(text(),'Jan')]");
		By SelectDateFeb = By.xpath("//option[contains(text(),'Feb')]");
		By SelectDateMar = By.xpath("//option[contains(text(),'Mar')]");
		By SelectDateApr = By.xpath("//option[contains(text(),'Apr')]");
		By SelectDateMay = By.xpath("//option[contains(text(),'May')]");
		By SelectDateJun = By.xpath("//option[contains(text(),'Jun')]");
		By SelectDateJul = By.xpath("//option[contains(text(),'Jul')]");
		By SelectDateAug = By.xpath("//option[contains(text(),'Aug')]");
		By SelectDateSep = By.xpath("//option[contains(text(),'Sep')]");
		By SelectDateOct = By.xpath("//option[contains(text(),'Oct')]");
		By SelectDateNov = By.xpath("//option[contains(text(),'Nov')]");
		By SelectDateDec = By.xpath("//body/div[4]/span[1]/select[3]/option[13]");

		driver.findElement(ClickDueDateDropdown).click();
		Thread.sleep(2000);
		driver.findElement(SelectDateJan).click();
		Thread.sleep(2000);
		driver.findElement(SelectDateFeb).click();
		Thread.sleep(2000);
		driver.findElement(SelectDateMar).click();
		Thread.sleep(2000);
		driver.findElement(SelectDateApr).click();
		Thread.sleep(2000);
		driver.findElement(SelectDateMay).click();
		Thread.sleep(2000);
		driver.findElement(SelectDateJun).click();
		Thread.sleep(2000);
		driver.findElement(SelectDateJul).click();
		Thread.sleep(2000);
		driver.findElement(SelectDateAug).click();
		Thread.sleep(2000);
		driver.findElement(SelectDateSep).click();
		Thread.sleep(2000);
		driver.findElement(SelectDateOct).click();
		Thread.sleep(2000);
		driver.findElement(SelectDateNov).click();
		Thread.sleep(2000);
		driver.findElement(SelectDateDec).click();
		Thread.sleep(2000);

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
