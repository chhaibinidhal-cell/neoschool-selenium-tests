package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class academicYearsPage {
	WebDriver driver;
	WebDriverWait wait;
	
	public academicYearsPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}

	private final By academicYearsPageTitle = By.xpath("//h1[normalize-space()='Academic Years']");
	private final By newAcademicYearsButton = By.xpath("//span[normalize-space()='New Academic Years']");
	private final By academicYearRows = By.xpath("//tr[contains(@class,'fi-ta-row')]");
	private final By setAsCurrentButton = By.xpath("(//span[contains(text(),'Set as Current')])[1]");
	private final By modalWindow = By.xpath("//div[@class='fi-modal-header flex px-6 pt-6 flex-col']");
	private final By confirmButton = By.xpath("//span[normalize-space()='Confirm']");
	private final By confirmationMessage = By.xpath("//div[contains(@class,'flex w-full gap-3 p-4')]");
	//private final By banner = By.xpath("(//*[contains(text(),\"working in the Current Academic Year\")])[1]");
	private final By banner = By.xpath("//div[@class='hidden lg:block']//div//div[@class='w-full text-center p-2 bg-green-400 rounded']");
	

	public boolean isOnAcademicYears() {
		String AcademicYearsPageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(academicYearsPageTitle)).getText();
		return AcademicYearsPageTitle.equals("Academic Years");
	}
	
	public void clickOnNewAcademicYears() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(newAcademicYearsButton)).click();
	}
	
	public boolean isAcademicYearDisplayedInList(String academicYear, String startDate, String endDate) {

	    List<WebElement> rows = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(academicYearRows));

	    for (WebElement row : rows) {
	        String rowText = row.getText();
	        if (rowText.contains(academicYear) && rowText.contains(startDate) && rowText.contains(endDate)) {
	            return true;
	        }
	    }
	    return false;
	}
	
	public void clickOnSetAsCurrent() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(setAsCurrentButton)).click();
	}
	
	public boolean isModalWindowDisplayed(){
		return wait.until(ExpectedConditions.visibilityOfElementLocated(modalWindow)).isDisplayed();
	}
	
	public void clickOnConfirmButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(confirmButton)).click();
	}
	
	public boolean confirmationMessageIsDisplayed() {
	    String confirmationMessageValue = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMessage)).getText();
	    return confirmationMessageValue.contains("Academic Year Switched Successfully")
	        && confirmationMessageValue.contains("You have successfully switched to a different academic year")
	        && confirmationMessageValue.contains("Your data are scoped accordingly");
	}
	
	public boolean bannerIsDisplayed() {
		String bannerValue = wait.until(ExpectedConditions.visibilityOfElementLocated(banner)).getText();
		return bannerValue.equals("You're working in the Current Academic Year. 2026/2027");
	}
	
	public boolean isBannerInTop() {
		Point position =wait.until(ExpectedConditions.visibilityOfElementLocated(banner)).getLocation();
		int y = position.getY();
		System.out.print("La position Y de la bannière est "+ y);
	    int windowHeight = driver.manage().window().getSize().getHeight();
		boolean isOnTop =y < (windowHeight * 0.15);
		return isOnTop;
	}
	

	
}
