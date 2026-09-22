package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
	WebDriver driver;
	WebDriverWait wait;
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}
	
	private final By DashboardPageTitle = By.xpath("//h1[normalize-space()='Admin Dashboard']");
	private final By AcademicYearsMenu = By.xpath("//span[normalize-space()='Academic Years']");


	//public String getDashboardPageTitle() {
		//return wait.until(ExpectedConditions.visibilityOfElementLocated(DashboardPageTitle)).getText();
	//}
	
	public boolean isOnDashboard() {
		String dashboardPageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(DashboardPageTitle)).getText();
		return dashboardPageTitle.contains("Dashboard");
	}
	public void clickOnAcademicYearsMenu() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(AcademicYearsMenu)).click();
	}
	
}
