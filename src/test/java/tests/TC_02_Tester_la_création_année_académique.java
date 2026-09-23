package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DashboardPage;
import pages.academicYearsPage;
import pages.loginPage;
import pages.newAcademicYearsPage;

public class TC_02_Tester_la_création_année_académique extends BaseTest {

	@Test
	public void testerLaGestionDesAnneesAcademiques() {
		
		loginPage Login = new loginPage(driver);
		DashboardPage dashboard = new DashboardPage(driver);
		academicYearsPage academicYears = new academicYearsPage(driver);
		newAcademicYearsPage newAcademicYears = new newAcademicYearsPage(driver);
		test=extent.createTest("TC02_Tester_la_création_année_académique");
		
		test.info("Se connecter");
	    Login.sendSchoolCode("neoschool");
	    Login.sendEmailAddress("admin@neoschool.test");
	    Login.sendPassword("edupassword!");
	    Login.clickOnSignInButton();
	    
		test.info("Cliquer sur le menu Academic Years");
		dashboard.clickOnAcademicYearsMenu();
		
		test.info("Vérifier que l'utilisateur est redirigé vers la page Academic Years");
		boolean academicYearsPageTitleResult = academicYears.isOnAcademicYears();
		Assert.assertTrue(academicYearsPageTitleResult, "La page Academic Years doit ètre affiché");
		
		test.info("Cliquer sur le bouton New Academic Years");
		academicYears.clickOnNewAcademicYears();
		
		test.info("Vérifier que l'utilisateur est redirigé vers la page Create Academic Years");
		boolean newAcademicYearsPageTitleResult = newAcademicYears.isOnNewAcademicYearsPage();
		Assert.assertTrue(newAcademicYearsPageTitleResult, "La page Create Academic Years doit ètre affiché");
		
		test.info("Cliquer sur Additional Labels Academic Year");
		newAcademicYears.clickOnAdditionalLabelsAcademicYear();
		
		test.info("Choisir la nouvelle année académique");
		newAcademicYears.clickOnAcademicYearChoice();
		
		test.info("Saisir les détails de la nouvelle année académique");
		String Details = "Année académique couvrant les deux semestres avec les périodes d'examens et les activités pédagogiques.";
		newAcademicYears.sendAdditionalLabelsDetails(Details);
		
		test.info("Vérifier la date initiale");
		boolean startDateValueResult = newAcademicYears.isStartDateEqualTo("2026-09-15");
		Assert.assertTrue(startDateValueResult, "la date initiale doit ètre 15/09/2026");
		
		test.info("Vérifier la date finale");
		boolean endDateValueResult = newAcademicYears.isEndDateEqualTo("2027-06-30");
		Assert.assertTrue(endDateValueResult, "la date finale doit ètre 30/06/2027");
		
		test.info("Cliquer sur le bouton Create");
		newAcademicYears.clickOnCreateButton();
		
		test.info("vérifier l'affichage du message de confirmation");
		boolean confirmationMessageResult = newAcademicYears.confirmationMessageIsDisplayed();
		Assert.assertTrue(confirmationMessageResult, "Le message de confirmation doit ètre affiché");
		
		test.info("Vérifier l'ajout de l'année académique à la liste des années académiques");
		String AcademicYear = "2026/2027";
		String StartDate = "Sep 15, 2026";
		String EndDate = "Jun 30, 2027";
		
		boolean newAcademicYearDisplayedInListResult = academicYears.isAcademicYearDisplayedInList(AcademicYear, StartDate, EndDate);
		Assert.assertTrue(newAcademicYearDisplayedInListResult, "La nouvelle année académique n'a pas été trouvée dans la liste.");
	}
}