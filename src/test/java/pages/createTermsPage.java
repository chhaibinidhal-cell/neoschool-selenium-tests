package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class createTermsPage {
	WebDriver driver;
	WebDriverWait wait;
	
	public createTermsPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}
	
	private final By createTermsPageTitle = By.xpath("//h1[normalize-space()='Create Terms']");
	private final By nameField = By.xpath("//input[@id='data.name']");
	private final By descriptionField = By.xpath("//textarea[@id='data.description']");
	private final By startDateField = By.xpath("//input[@id='data.starts_at']");
	//private final By startDay = By.xpath("//div[@class='rounded-full text-center text-sm leading-loose transition duration-75 cursor-pointer text-primary-600 bg-gray-50 dark:bg-white/5 dark:text-primary-400']");
	private final By endDateField = By.xpath("//input[@id='data.ends_at']");
	private final By createButton = By.xpath("//span[@class='fi-btn-label'][normalize-space()='Create']");
	private final By yearField = By.xpath("(//input[@x-model.debounce='focusedYear'])[1]");


	
	public boolean isOnCreateTerms() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(createTermsPageTitle)).isDisplayed();
	}
	
	public void sendNameValue(String NameValue) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(nameField)).sendKeys(NameValue);
	}
	
	public void sendDescriptionValue(String descriptionValue) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(descriptionField)).sendKeys(descriptionValue);
	}
		
	public void chooseStartDate(String year, String day) {
	    wait.until(ExpectedConditions.visibilityOfElementLocated(startDateField)).click();
	    WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(yearField));
	    field.click();
	    field.sendKeys(Keys.chord(Keys.CONTROL, "a"));
	    field.sendKeys(year);
	    try {
	        Thread.sleep(500);
	    } catch (InterruptedException e) {
	        Thread.currentThread().interrupt();
	    }
	    By dayCell = By.xpath("(//div[@role='option' and normalize-space()='" + day + "'])[1]");
	    wait.until(ExpectedConditions.elementToBeClickable(dayCell)).click();
	    driver.findElement(startDateField).sendKeys(Keys.ESCAPE);
	}
	
	public boolean isEndDateEqualTo(String expectedEndDate) {
		try {
	        Thread.sleep(500);
	    } catch (InterruptedException e) {
	        Thread.currentThread().interrupt();
	    }
	    WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(endDateField));
	    wait.until(ExpectedConditions.attributeToBeNotEmpty(field, "value"));
	    String actual = field.getAttribute("value");
	    return actual.equals(expectedEndDate);
	}
	
	public void clickOnCreateButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(createButton)).click();
	}
	

}
