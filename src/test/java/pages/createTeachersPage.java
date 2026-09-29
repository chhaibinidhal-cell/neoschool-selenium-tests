package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class createTeachersPage {
	WebDriver driver;
	WebDriverWait wait;
	
	public createTeachersPage(WebDriver driver) {
	this.driver = driver;
	this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}
	
	private final By firstNameField = By.xpath("//input[@id='data.first_name']");
	private final By lastNameField = By.xpath("//input[@id='data.last_name']");
	private final By birthDateField = By.xpath("//input[@id='data.dob']");
	private final By emailField = By.xpath("//input[@id='data.email']");
	private final By genderField = By.xpath("//select[@id='data.gender']");
	private final By genderOption = By.id("data.gender");
	private final By phoneNumberField = By.xpath("//input[@id='data.phone']");
	private final By postalCodeField = By.xpath("//input[@id='data.postal_code']");
	private final By addressField = By.xpath("//input[@id='data.address']");
	private final By employeeNumberField = By.xpath("//input[@id='data.employee_number']");
	private final By statusField = By.xpath("//select[@id='data.status']");
	private final By statusOption = By.id("data.status");
	private final By profilePhoto = By.cssSelector("input.filepond--browser[type='file']");
	private final By uploadedPhoto = By.cssSelector(".filepond--list .filepond--item");
	private final By createButton = By.xpath("//span[@class='fi-btn-label'][normalize-space()='Create']");
	
	
	public boolean isOnCreateTeachers() {
		String pageUrl = driver.getCurrentUrl();
		return pageUrl.contains("teachers/create");
	}
	
	public void sendFirstName(String firstNameValue) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).sendKeys(firstNameValue);
	}
	
	public void sendLastName(String lastNameValue) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField)).sendKeys(lastNameValue);
	}
	
	public void sendBirthDate(String birthDateValue) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(birthDateField)).sendKeys(birthDateValue);
	}
	
	public void clickOnGenderList() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(genderField)).click();
	}
	
	public void selectGender(String value) {
	    Select select = new Select(driver.findElement(genderOption));
	    select.selectByValue(value);
	}
	
	public void sendEmailValue(String emailValue) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(emailValue);
	}
	
	public void sendPhoneNumberValue(String phoneNumberNumberValue) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNumberField)).sendKeys(phoneNumberNumberValue);
	}
	
	public void sendPostalCodeValue(String postalCodeValue) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(postalCodeField)).sendKeys(postalCodeValue);
	}
	
	public void sendAdressValue(String addressValue) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(addressField)).sendKeys(addressValue);
	}
	
	
	public void clickOnStatusList() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(statusField)).click();
	}
	
	public void selectStatus(String value) {
	    Select select = new Select(driver.findElement(statusOption));
	    select.selectByValue(value);
	}
	
	public boolean isEmployeeNumberDisplayed() {

	    String value = driver.findElement(employeeNumberField).getAttribute("value");

	    return value != null && value.matches("\\d+");
	}
	
	public void uploadProfilePhoto(String filePath) {
	    WebElement fileInput = wait.until(ExpectedConditions.presenceOfElementLocated(profilePhoto));
	    fileInput.sendKeys(filePath);
	}
	
	public boolean isProfilePhotoDisplayed() {
	    return wait.until(ExpectedConditions.visibilityOfElementLocated(uploadedPhoto)).isDisplayed();
	}
	
	public void clickOnCreateButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(createButton)).click();
	}
	
	
}
