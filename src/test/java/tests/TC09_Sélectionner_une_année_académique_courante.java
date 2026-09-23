package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DashboardPage;
import pages.academicYearsPage;
import pages.loginPage;

public class TC09_Sélectionner_une_année_académique_courante extends BaseTest {

	@Test
	
	public void testerLaSélectionUneAnnéeAcadémiqueCourante () {
		loginPage Login = new loginPage(driver);
		DashboardPage dashboard = new DashboardPage(driver);
		academicYearsPage academicYears = new academicYearsPage(driver);
		test=extent.createTest("TC09_Sélectionner_une_année_académique_courante");
		
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
		
		test.info("Cliquer sur set as current");
		academicYears.clickOnSetAsCurrent();
		
		test.info("Vérifier que la fenètre s'affiche");
		boolean modalWindowIsDisplayedResult = academicYears.isModalWindowDisplayed();
		Assert.assertTrue(modalWindowIsDisplayedResult, "La fenètre doit ètre affichée");
		
		test.info("Cliquer sur confirm");
		academicYears.clickOnConfirmButton();
		
		test.info("Vérifier l'affichage du message de confirmation");
		boolean confirmationMessageIsDisplayedResult = academicYears.confirmationMessageIsDisplayed();
		Assert.assertTrue(confirmationMessageIsDisplayedResult, "Le message de confirmation doit ètre affiché");
		
		test.info("Vérifier l'affichage de la bannière");
		boolean bannerIsDisplayedResult = academicYears.bannerIsDisplayed();
		Assert.assertTrue(bannerIsDisplayedResult, "La bannière doit ètre affichée");
		
		test.info("Vérifier la position de la bannière");
		boolean bannerIsOnTopResult = academicYears.isBannerInTop();
		Assert.assertTrue(bannerIsOnTopResult, "La bannière doit ètre en haut de la page");
		
	}
}
