package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class createClassesPage {
	WebDriver driver;
	WebDriverWait wait;
	
	public createClassesPage (WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}
	
	private final By createClassesPageTitle = By.xpath("//h1[normalize-space()='Create Classes']");
	private final By nameField = By.xpath("//input[@id='data.name']");
	private final By createButton = By.xpath("//span[@class='fi-btn-label'][normalize-space()='Create']");
	private final By levelField = By.xpath("//select[@id='data.level_id']");
	private final By levelOption = By.id("data.level_id");
	private final By errorMessage = By.cssSelector("p[data-validation-error]");


	
	public boolean isOnCreateClassesPage() {
		String dashboardPageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(createClassesPageTitle)).getText();
		return dashboardPageTitle.contains("Create Classes");
	}

	public void sendNameValue(String nameValue) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(nameField)).sendKeys(nameValue);
	}
	
	public void clickOnCreateButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(createButton)).click();
	}
	
	public boolean isFirstErrorMessageDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).isDisplayed();
	}
	
	public void clearNameField() {
	    wait.until(ExpectedConditions.visibilityOfElementLocated(nameField)).clear();
	}
	
	
	public void selectLevel(String value) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(levelField)).click();
	    Select select = new Select(driver.findElement(levelOption));
	    select.selectByValue(value);
	}
	
	public boolean isSecondErrorMessageDisplayed() {
		WebElement nameFieldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(nameField));
		return !(Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].checkValidity();",
				nameFieldElement);
	}
	
	
}
