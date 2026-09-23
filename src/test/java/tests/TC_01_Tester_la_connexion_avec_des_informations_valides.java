package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DashboardPage;
import pages.loginPage;

public class TC_01_Tester_la_connexion_avec_des_informations_valides extends BaseTest {
	
	@Test
	public void testerLaConnexionAvecDesInformationsValides() {
		loginPage Login = new loginPage(driver);
		DashboardPage Dashboard = new DashboardPage(driver);
		test=extent.createTest("TC01_Tester_la_connexion_avec_Des_Inormations_valides");
		
		test.info("Vérifier que La page Neoschool Sign in s'affiche correctement avec le champ School Code");
		boolean SchoolCodeIsDisplayedResult = Login.SchoolCodeIsDisplayed();
		Assert.assertTrue(SchoolCodeIsDisplayedResult, "le champ School Code doit ètre affiché");
		
		test.info("Vérifier que la page Neoschool Sign in s'affiche correctement avec le champ Email Address");
		boolean EmailAddressIsDisplayedResult = Login.EmailAddressIsDisplayed();
		Assert.assertTrue(EmailAddressIsDisplayedResult, "le champ Email Adress doit ètre affiché");
		
		test.info("Vérifier que la page Neoschool Sign in s'affiche correctement avec le champ Password");
		boolean PasswordIsDisplayedResult = Login.PasswordIsDisplayed();
		Assert.assertTrue(PasswordIsDisplayedResult, "le champ Password doit ètre affiché");
		
		test.info("Saisir le School Code");
		String schoolCode = "neoschool";
		Login.sendSchoolCode(schoolCode);
		
		test.info("saisir l'adresse mail");
		String EmailAddress = "admin@neoschool.test";
		Login.sendEmailAddress(EmailAddress);
		
		test.info("saisir le Password");
		String Password = "edupassword!";
		Login.sendPassword(Password);
		
		test.info("Cliquer sur le bouton Sign in");
		Login.clickOnSignInButton();
		
		test.info("Vérifier que l'utilisateur est redirigé vers la page dashboard");
		boolean DashboardPageTitleResult = Dashboard.isOnDashboard();
		Assert.assertTrue(DashboardPageTitleResult, "l'utilisateur doit ètre redirigé vers la page dashboard");				
	}

}
