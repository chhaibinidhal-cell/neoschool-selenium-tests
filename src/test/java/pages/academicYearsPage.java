package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
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
}
