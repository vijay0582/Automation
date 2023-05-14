package test;

import java.util.Set;

import org.checkerframework.checker.units.qual.s;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleWindowHandle {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		String parentid = driver.getWindowHandle();
		System.out.println(parentid);
		WebElement Btn = driver.findElement(By.xpath("//button[@id='newWindowBtn']"));
		Btn.click();
		Set<String> allWindows = driver.getWindowHandles();
		for (String s : allWindows) {
			if (!parentid.equals(s)) {
				driver.switchTo().window(s);
				String windowTittle = driver.getTitle();
				if (windowTittle.contains("AlertDemo")) {
					WebElement clickMeBtn = driver.findElement(By.xpath("//button[@id='alertBox']"));
					clickMeBtn.click();

				}
				break;
			}

		}

	}
}
