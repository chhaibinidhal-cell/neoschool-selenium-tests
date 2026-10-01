package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class createdClassePage {
	WebDriver driver;
	WebDriverWait wait;
	
	public createdClassePage (WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}
	
	private final By createMessage = By.xpath("//h3[normalize-space()='Created']");
	private final By classesMenu = By.xpath("//span[normalize-space()='Classes']");
	//private final By pageHeading = By.className("fi-header-heading");


	public boolean isCreateMessageDisplayed() {
		String CreateMessageValue = wait.until(ExpectedConditions.visibilityOfElementLocated(createMessage)).getText();
		return CreateMessageValue.equals("Created");
	}
	
	public void clickOnClassesMenu() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(classesMenu)).click();
	}
	
	//public boolean isClasseAdded(String levelName, String classeName) {
	//	String ClassePageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(pageHeading)).getText();
	//			if (ClassePageTitle.contains(levelName) && ClassePageTitle.contains(classeName)) {
	//	            return true;
	//	        }
	//	    return false;
	//}
	
}
