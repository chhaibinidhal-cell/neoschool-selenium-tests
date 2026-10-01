package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DashboardPage;
import pages.createLevelsPage;
import pages.levelsPage;
import pages.loginPage;

public class TC_06_Créer_un_niveau extends BaseTest{
	
	@Test
	
	public void testerLaCréationDunNiveau() {
		loginPage Login = new loginPage(driver);
		DashboardPage dashboard = new DashboardPage(driver);
		levelsPage levels = new levelsPage(driver);
		createLevelsPage createLevels = new createLevelsPage(driver);
		test=extent.createTest("TC06_Tester_la_création_niveau");
		

		test.info("Se connecter");
	    Login.sendSchoolCode("neoschool");
	    Login.sendEmailAddress("admin@neoschool.test");
	    Login.sendPassword("edupassword!");
	    Login.clickOnSignInButton();
	    
	    test.info("cliquer sur le menu Levels");
	    dashboard.clickOnLevelsMenu();
	    
	    test.info("Vérifier l'affichage de la page Levels");
	    boolean isLevelsPageDisplayedResult = levels.isOnLevelsPage();
	    Assert.assertTrue(isLevelsPageDisplayedResult, "La page Levels doit ètre affichée");
	    
	    test.info("Cliquer sur New Levels");
	    levels.clickOnNewLevelsButton();
	    
	    test.info("Vérifier l'affichage de la page Create Levels");
	    boolean isCreateLevelsPageDisplayedResult = createLevels.isOnCreateLevels();
	    Assert.assertTrue(isCreateLevelsPageDisplayedResult, "La page Create Levels doit ètre affichée");	
	    
	    test.info("Cliquer sur le bouton Create sans saisir un nom");
	    createLevels.clickOnCreateButton();
	    
	    test.info("Vérifier l'affichage du message d'erreur");
	    boolean isErrorMessageDisplayed = createLevels.isErrorMessageDisplayed();
	    Assert.assertTrue(isErrorMessageDisplayed, "Le message d'erreur doit ètre affiché");
	    
	    test.info("Saisir le nom du niveau");
	    String levelName = "Niveau 1";
	    createLevels.sendName(levelName);
	    
	    test.info("Cliquer sur le bouton Create");
	    createLevels.clickOnCreateButton();
	    
	    test.info("Vérifier l'affichage du message de confirmation");
	    boolean isCofirmationMessageDisplayedResult = levels.isCreateMessageDisplayed();
	    Assert.assertTrue(isCofirmationMessageDisplayedResult, "le message de confirmation de création doit ètre affiché");
	    
	    test.info("Vérifier que le niveau apparait dans la liste");
	    boolean isLevelOnListResult = levels.isLevelDisplayedInList(levelName);
	    Assert.assertTrue(isLevelOnListResult, "le niveau doit apparaitre dans la liste");
	    
	}

}
