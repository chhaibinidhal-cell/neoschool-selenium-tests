package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DashboardPage;
import pages.academicYearsPage;
import pages.createTermsPage;
import pages.loginPage;
import pages.newAcademicYearsPage;
import pages.termsPage;

public class TC_03_Créer_un_trimestre extends BaseTest {
	
	@Test
	
	public void TesterLaCréationDunTrimestre() {
		loginPage Login = new loginPage(driver);
		DashboardPage dashboard = new DashboardPage(driver);
		academicYearsPage academicYears = new academicYearsPage(driver);
		newAcademicYearsPage newAcademicYears = new newAcademicYearsPage(driver);
		termsPage terms = new termsPage(driver);
		createTermsPage createTerms = new createTermsPage(driver);
		test=extent.createTest("TC03_Tester_la_création_trimestre");
		
		test.info("Se connecter");
	    Login.sendSchoolCode("neoschool");
	    Login.sendEmailAddress("admin@neoschool.test");
	    Login.sendPassword("edupassword!");
	    Login.clickOnSignInButton();
	    
		
	    
	    test.info("Rendre l'année académique courante 2027/2028");
		dashboard.clickOnAcademicYearsMenu();
		academicYears.clickOnNewAcademicYears();
		newAcademicYears.clickOnAdditionalLabelsAcademicYear();
		newAcademicYears.clickOnAcademicYearChoice("2027/2028");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
         //TODO Auto-generated catch block
			e.printStackTrace();
		}
		newAcademicYears.clickOnCreateButton();
		academicYears.clickOnSetAsCurrent("2027/2028");
		academicYears.clickOnConfirmButton();

		//test.info("Vérifier l'affichage du message de confirmation");
		//boolean confirmationDisplayed = academicYears.confirmationMessageIsDisplayed();
		//Assert.assertTrue(confirmationDisplayed, "Le message de confirmation doit être affiché")
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		academicYears.clickOnDashboard();
		dashboard.clickOnTermsMenu();
	    
	    test.info("vérifier l'affichage de la page Terms");
	    boolean termsPageTitleValue = terms.isOnTerms();
	    Assert.assertTrue(termsPageTitleValue, "la page Terms doit s'afficher");
	    
	    test.info("cliquer sur new terms");
	    terms.clickOnNewTerms();
	    
	    test.info("vérifier l'affichage de la page Create Terms");
	    boolean createTermsPageTitleValue = createTerms.isOnCreateTerms();
	    Assert.assertTrue(createTermsPageTitleValue, "la page Create Terms doit s'afficher");
	    
	    test.info("rensiegner les données du trimestre");
	    createTerms.sendNameValue("Premier Trimestre");
	    createTerms.sendDescriptionValue("Premier trimestre de l'année académique 2027/2028");
	    
	    test.info("indiquer le début du trimestre");
	    createTerms.chooseStartDate("2027", "15");
	    
	    test.info("Vérifier la date finale du trimestre");
		boolean endDateValueResult = createTerms.isEndDateEqualTo("15/12/2027");
		Assert.assertTrue(endDateValueResult, "la date finale doit ètre 15/12/2027");
		
		test.info("cliquer sur Create");
		createTerms.clickOnCreateButton();
		
		test.info("Vérifier l'affichage du message de création");
		boolean isCreateMessageDisplayedResult = terms.isCreateMessageDisplayed();
		Assert.assertTrue(isCreateMessageDisplayedResult, "Le message de création doit ètre affiché");
		
		test.info("Vérifier que le nouveau trimestre se trouve dans la liste");
		String termName = "Premier Trimestre";
		String StartDate = "15 Sep 2027";
		String EndDate = "15 Dec 2027";
		
		boolean isTermeDisplayedInListResult = terms.isTermDisplayedInList(termName, StartDate, EndDate);
		Assert.assertTrue(isTermeDisplayedInListResult, "Le nouveau trimestre doit ètre affiché dans la liste");
	}

}
