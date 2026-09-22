package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class newAcademicYearsPage {
	WebDriver driver;
	WebDriverWait wait;
	
	public newAcademicYearsPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}
	private final By newAcademicYearsTitle = By.xpath("//h1[normalize-space()='Create Academic Years']");
	private final By additionalLabelsAcademicYear = By.xpath("//div[@class='choices__inner']");
	private final By academicYearChoice = By.xpath("//div[@id='choices--dataname-item-choice-3']");
	private final By additionalLabelsDetails = By.xpath("//textarea[@id='data.description']");
	private final By startDateField = By.xpath("//input[@id='data.starts_at']");
	private final By endDateField = By.xpath("//input[@id='data.ends_at']");
	private final By createButton = By.xpath("//span[contains(@class,'fi-btn-label')][normalize-space()='Create']");
	private final By confirmationMessage = By.xpath("//h3[normalize-space()='Academic Year has been created successfully !']");

	
	public boolean isOnNewAcademicYearsPage () {
		String newAcademicYears_Title = wait.until(ExpectedConditions.visibilityOfElementLocated(newAcademicYearsTitle)).getText();
		return newAcademicYears_Title.equals("Create Academic Years");
	}
	
	public void clickOnAdditionalLabelsAcademicYear() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(additionalLabelsAcademicYear)).click();
	}
	
	public void clickOnAcademicYearChoice() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(academicYearChoice)).click();
	}
	
	
	public void sendAdditionalLabelsDetails(String additionalLabelsDetailsValue) {
	    WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(additionalLabelsDetails));
	    field.click();
	    field.sendKeys(additionalLabelsDetailsValue);
	}
	
	public boolean isStartDateEqualTo(String expectedStartDate) {
	    WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(startDateField));
	    wait.until(ExpectedConditions.attributeToBeNotEmpty(field, "value"));
	    String actual = field.getAttribute("value");
	    return actual.equals(expectedStartDate);
	}
	
	public boolean isEndDateEqualTo(String expectedEndDate) {
	    WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(endDateField));
	    wait.until(ExpectedConditions.attributeToBeNotEmpty(field, "value"));
	    String actual = field.getAttribute("value");
	    return actual.equals(expectedEndDate);
	}
	
	public void clickOnCreateButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(createButton)).click();
	}
	
	public boolean confirmationMessageIsDisplayed() {
		String confirmationMessageValue = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMessage)).getText();
		return confirmationMessageValue.equals("Academic Year has been created successfully !");
	}
	
}
