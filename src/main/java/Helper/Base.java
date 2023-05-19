package Helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static Properties prop;
	public static WebDriver driver;

	static {
		try {
			FileInputStream file = new FileInputStream("TestData/Data.properties");
			prop = new Properties();
			prop.load(file);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void setup() {

		String browser = prop.getProperty("Browser");

		if (browser.equals("chrome")) {

			WebDriverManager.chromedriver().setup();
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--remote-allow-origins=*");
			option.addArguments("--incognito");

			driver = new ChromeDriver(option);
		} else if (browser.equals("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions option = new FirefoxOptions();
			option.addArguments("--remote-allow-origins=*");
			option.addArguments("--incognito");

			driver = new FirefoxDriver(option);
		} else if (browser.equals("edge")) {

			WebDriverManager.edgedriver().setup();
			EdgeOptions option = new EdgeOptions();
			option.addArguments("--remote-allow-origins=*");
			option.addArguments("--incognito");

			driver = new EdgeDriver(option);

		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(prop.getProperty("url"));
		// System.out.println(Driver);
	}

	public void waitForExpectedElement(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ele));

	}

	public void waitForAlert(int timout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timout));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public void waitForElementclickable(WebElement ele, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	public void mouseHover(WebElement ele) {
		Actions a = new Actions(driver);
		a.moveToElement(ele).build().perform();
	}

	public void selectAlertpopup(int timeout) {
		waitForAlert(timeout);
		Alert a = driver.switchTo().alert();
		a.accept();
	}

	public void selectDropDownbyVisibleText(WebElement ele, int value) {
		Select s = new Select(ele);
		s.selectByIndex(value);

	}

	public void takeScreenshot() {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File scrFile = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("Screenshots/test/png"));
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	public void tearDown(Scenario s) {
		if (s.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File scrFile = ts.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(scrFile, new File("Screenshots" + s.getName() + ".png"));
			} catch (IOException e) {
				e.printStackTrace();

			}
			driver.quit();
		}

	}
}
