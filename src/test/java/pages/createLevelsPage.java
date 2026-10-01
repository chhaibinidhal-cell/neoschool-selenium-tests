package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class createLevelsPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public createLevelsPage(WebDriver driver) {
	this.driver = driver;
	this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}
	
	private final By nameField = By.xpath("//input[@id='data.name']");
	private final By createButton = By.xpath("//span[@class='fi-btn-label'][normalize-space()='Create']");

	
	public boolean isOnCreateLevels() {
		String pageUrl = driver.getCurrentUrl();
		return pageUrl.contains("levels/create");
	}
	

	public String getNameFieldValidationMessage() {
	    WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(nameField));
	    return field.getAttribute("validationMessage");
	}
	
	public void clickOnCreateButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(createButton)).click();
	}
	
	public boolean isErrorMessageDisplayed() {

		WebElement nameFieldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(nameField));
		return !(Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].checkValidity();",
				nameFieldElement);
	}

	public void sendName(String NameValue) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(nameField)).sendKeys(NameValue);
	}
	

}
