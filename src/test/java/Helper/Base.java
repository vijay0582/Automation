package Helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.bouncycastle.jcajce.provider.symmetric.Serpent.TSerpentGMAC;
import org.checkerframework.checker.units.qual.s;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
public static WebDriver driver;

public void setup() {

	WebDriverManager.chromedriver().setup();
	ChromeOptions options= new ChromeOptions();
	options.addArguments("__incognito");
	driver = new ChromeDriver();
	driver.get("https:www.saucedemo.com/");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	}
public void waitForExpectedElement(WebElement ele) {
	WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(ele));
	
}
public void waitForAlert(int timout) {
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timout));
	wait.until(ExpectedConditions.alertIsPresent());
}
public void waitForElementclickable(WebElement ele,int timeout) {
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout) );
	wait.until(ExpectedConditions.elementToBeClickable(ele));
}
public void mouseHover(WebElement ele) {
	Actions a=new Actions(driver);
	a.moveToElement(ele).build().perform();
}
public void selectAlertpopup(int timeout) {
	waitForAlert(timeout);
	Alert a= driver.switchTo().alert();
	a.accept();
}

public void selectDropDownbyVisibleText(WebElement ele,int value) {
	Select s=new Select(ele);
	s.selectByIndex(value);
	
	
}
public void takeScreenshot() {
	TakesScreenshot ts=(TakesScreenshot) driver;
	File scrFile = ts.getScreenshotAs(OutputType.FILE);
	try {
		FileUtils.copyFile(scrFile,new File("Screenshots/test/png"));
	}
	catch (IOException e) {
		e.printStackTrace();
	
	}
	}
}

