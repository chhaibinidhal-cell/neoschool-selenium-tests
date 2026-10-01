package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class levelsPage {
	WebDriver driver;
	WebDriverWait wait;
	
	public levelsPage(WebDriver driver) {
	this.driver = driver;
	this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}
	
	
	private final By newLevelsButton = By.xpath("//span[normalize-space()='New Levels']");
	private final By createMessage = By.xpath("//h3[normalize-space()='Created']");
	private final By levelsRows = By.xpath("//tr[contains(@class,'fi-ta-row')]");	



	
	public boolean isOnLevelsPage() {
		String pageUrl = driver.getCurrentUrl();
		return pageUrl.contains("levels");	
	}
	
	public void clickOnNewLevelsButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(newLevelsButton)).click();
	}
	
	public boolean isCreateMessageDisplayed() {
		String CreateMessageValue = wait.until(ExpectedConditions.visibilityOfElementLocated(createMessage)).getText();
		return CreateMessageValue.equals("Created");
	}
	
	public boolean isLevelDisplayedInList(String levelName) {

	    List<WebElement> rows = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(levelsRows));

	    for (WebElement row : rows) {
	        String rowText = row.getText();
	        if (rowText.contains(levelName)) {
	            return true;
	        }
	    }
	    return false;
	}
	
}
