package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class studentsPage {
	WebDriver driver;
	WebDriverWait wait;

	public studentsPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}
	
	private final By studentsPageTitle = By.xpath("//h1[normalize-space()='Students']");
	private final By newStudentsButton = By.xpath("//span[normalize-space()='New Students']");
	private final By createMessage = By.xpath("//h3[normalize-space()='Created']");
	private final By studentRow = By.xpath("//tr[contains(@class,'fi-ta-row')]");



	
	public boolean isOnStudentsPage() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(studentsPageTitle)).isDisplayed();
	}
	
	public void clickOnNewStudentsButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(newStudentsButton)).click();
	}
	
	public boolean isCreateMessageDisplayed() {
		String CreateMessageValue = wait.until(ExpectedConditions.visibilityOfElementLocated(createMessage)).getText();
		return CreateMessageValue.equals("Created");
	}
	
	public boolean isStudentDisplayedInList(String fullName) {

	    List<WebElement> rows = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(studentRow));

	    for (WebElement row : rows) {
	        String rowText = row.getText();
	        if (rowText.contains(fullName)) {
	            return true;
	        }
	    }
	    return false;
	}

}
