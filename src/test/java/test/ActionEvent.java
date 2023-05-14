package test;

import java.awt.RenderingHints.Key;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.description.ModifierReviewable.OfAbstraction;

public class ActionEvent {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.get("https://www.browserstack.com/");
	    driver.manage().window().maximize();
	    Actions action= new  Actions(driver);
	    WebElement productMenu=driver.findElement(By.xpath("//button[@id='product-menu-toggle']"));
	    action.moveToElement(productMenu).build().perform();
	    WebElement liveMenu=driver.findElement(By.xpath("//a[@class='menu-item-live']"));
	    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(liveMenu));	    
	    action.click(liveMenu).build().perform();
	    WebElement searchInput= driver.findElement(By.xpath("//input[@id='live-form-url']"));
	    JavascriptExecutor js=((JavascriptExecutor)driver);
	    js.executeScript("arguments[0].scrollIntoView(true);",searchInput);
	    Thread.sleep(3000);
	    searchInput.sendKeys("Test");
	    action.sendKeys(Keys.ENTER).build().perform();
	    
	    

	}

}
