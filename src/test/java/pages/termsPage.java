package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class termsPage {
	WebDriver driver;
	WebDriverWait wait;
	
	public termsPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}
	
	private final By termsPageTitle = By.xpath("//h1[normalize-space()='Terms']");
	private final By newTermsButton = By.xpath("//span[normalize-space()='New Terms']");
	private final By createMessage = By.xpath("//h3[normalize-space()='Created']");
	private final By termeRow = By.xpath("//tr[contains(@class,'fi-ta-row')]");

	
	public boolean isOnTerms() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(termsPageTitle)).isDisplayed();
	}
	
	public void clickOnNewTerms() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(newTermsButton)).click();
	}
	
	public boolean isCreateMessageDisplayed() {
		String CreateMessageValue = wait.until(ExpectedConditions.visibilityOfElementLocated(createMessage)).getText();
		return CreateMessageValue.equals("Created");
	}
	
	public boolean isTermDisplayedInList(String termName, String startDate, String endDate) {

	    List<WebElement> rows = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(termeRow));

	    for (WebElement row : rows) {
	        String rowText = row.getText();
	        if (rowText.contains(termName) && rowText.contains(startDate) && rowText.contains(endDate)) {
	            return true;
	        }
	    }
	    return false;
	}

}
