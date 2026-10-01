package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class classesPage {
	WebDriver driver;
	WebDriverWait wait;
	
	public classesPage (WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}
	
	private final By newClassesButton = By.xpath("//span[normalize-space()='New Classes']");
	private final By classesRows = By.xpath("//tr[contains(@class,'fi-ta-row')]");	



	
	public boolean isOnClassesPage() {
		String url = driver.getCurrentUrl();
		return url.contains("classes");
	}
	
	public void clickOnNewClassesButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(newClassesButton)).click();
	}
	
	
	public boolean isClasseDisplayedInList(String levelName, String classeName) {

	    List<WebElement> rows = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(classesRows));

	    for (WebElement row : rows) {
	        String rowText = row.getText();
	        if (rowText.contains(levelName) && rowText.contains(classeName)) {
	            return true;
	        }
	    }
	    return false;
	}
	

}
