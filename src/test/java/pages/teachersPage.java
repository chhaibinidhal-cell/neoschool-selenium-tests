package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class teachersPage {
	WebDriver driver;
	WebDriverWait wait;
	
	public teachersPage(WebDriver driver) {
	this.driver = driver;
	this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}
	
	private final By newTeachersButton = By.xpath("//span[normalize-space()='New Teachers']");
	private final By createMessage = By.xpath("//h3[normalize-space()='Created']");
	private final By teachersRow = By.xpath("//tr[contains(@class,'fi-ta-row')]");	


	
	public boolean isOnTeachersPage() {
		String pageUrl = driver.getCurrentUrl();
		return pageUrl.contains("teachers");	
	}
	
	public void clickOnNewTeachersButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(newTeachersButton)).click();
	}
	
	public boolean isCreateMessageDisplayed() {
		String CreateMessageValue = wait.until(ExpectedConditions.visibilityOfElementLocated(createMessage)).getText();
		return CreateMessageValue.equals("Created");
	}
	
	public boolean isTacherDisplayedInList(String fullName, String phoneNumber) {

	    List<WebElement> rows = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(teachersRow));

	    for (WebElement row : rows) {
	        String rowText = row.getText();
	        if (rowText.contains(fullName) && rowText.contains(phoneNumber)) {
	            return true;
	        }
	    }
	    return false;
	}

}
