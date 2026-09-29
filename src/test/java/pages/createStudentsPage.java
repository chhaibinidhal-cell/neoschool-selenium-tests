package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class createStudentsPage {
	WebDriver driver;
	WebDriverWait wait;
	
	public createStudentsPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}
	
	private final By firstNameField = By.xpath("//input[@id='data.first_name']");
	private final By lastNameField = By.xpath("//input[@id='data.last_name']");
	private final By birthDateField = By.xpath("//input[@id='data.dob']");
	private final By genderField = By.xpath("//select[@id='data.gender']");
	private final By genderOption = By.id("data.gender");
	private final By admissionNumberField = By.xpath("//input[@id='data.admission_number']");
	//private final By browseButton = By.xpath("//span[@class='filepond--label-action']");
	private final By profilePhoto = By.cssSelector("input.filepond--browser[type='file']");
	private final By uploadedPhoto = By.cssSelector(".filepond--list .filepond--item");
	private final By createButton = By.xpath("//span[@class='fi-btn-label'][normalize-space()='Create']");
	
	
	public boolean isOnCreateStudents() {
		String pageUrl = driver.getCurrentUrl();
		return pageUrl.contains("students/create");
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
	
	public void sendAdmissionNumberValue(String admissionNumberValue) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(admissionNumberField)).sendKeys(admissionNumberValue);
	}
	
	//public void clickOnBrowse() {
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(browseButton)).click();
	//}
	
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
