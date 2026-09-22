package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPage {
	WebDriver driver;
	WebDriverWait wait;
	
	public loginPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}
	
	private final By SchoolCode = By.xpath("//span[normalize-space()='School Code']");
	private final By EmailAddress = By.xpath("//span[contains(text(),'Email address')]");
	private final By Password = By.xpath("//span[contains(text(),'Password')]");
	
	private final By SchoolCodeField = By.xpath("//input[@id='data.school_code']");
	private final By EmailAddressField = By.xpath("//input[@id='data.email']");
	private final By PasswordField = By.xpath("//input[@id='data.password']");
	private final By SignIn_Button = By.xpath("//button[@type='submit']");

	
	public boolean SchoolCodeIsDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(SchoolCode)).isDisplayed();
	}

	public boolean EmailAddressIsDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(EmailAddress)).isDisplayed();
	}

	public boolean PasswordIsDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(Password)).isDisplayed();
	}
	
	public void sendSchoolCode(String SchoolCodeValue) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(SchoolCodeField)).sendKeys(SchoolCodeValue);
	}
	
	public void sendEmailAddress(String EmailAddressValue) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(EmailAddressField)).sendKeys(EmailAddressValue);
	}	
	public void sendPassword(String PasswordValue) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(PasswordField)).sendKeys(PasswordValue);
	}
	
	public void clickOnSignInButton () {
		wait.until(ExpectedConditions.visibilityOfElementLocated(SignIn_Button)).click();
	}
	
}
