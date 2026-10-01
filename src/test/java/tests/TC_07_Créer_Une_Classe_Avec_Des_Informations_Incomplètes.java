package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DashboardPage;
import pages.classesPage;
import pages.createClassesPage;
import pages.loginPage;

public class TC_07_Créer_Une_Classe_Avec_Des_Informations_Incomplètes extends BaseTest {
	
	@Test
	public void TesterLaCréationDuneClasseAvecDesInformatiosInvalides() {
		loginPage login = new loginPage(driver);
		DashboardPage dashboard = new DashboardPage(driver);
		classesPage classes = new classesPage(driver);
		createClassesPage createClasses = new createClassesPage(driver);
		test=extent.createTest("TC_07_Créer_Une_Classe_Avec_Des_Informations_Incomplètes");
		
		test.info("Se connecter");
	    login.sendSchoolCode("neoschool");
	    login.sendEmailAddress("admin@neoschool.test");
	    login.sendPassword("edupassword!");
	    login.clickOnSignInButton();
	    
	    test.info("cliquer sur le menu Classes");
	    dashboard.clickOnClassesMenu();
	    
	    test.info("Vérifier l'affichage de la page Classes");
	    boolean isClassesPageDisplayedResult = classes.isOnClassesPage();
	    Assert.assertTrue(isClassesPageDisplayedResult, "La page Classes doit ètre affichée");
	    
	    test.info("cliquer sur le bouton New Classes");
	    classes.clickOnNewClassesButton();
	    
	    test.info("Vérifier l'affichage de la page Create Classes");
	    boolean isOnCreateClassesResult = createClasses.isOnCreateClassesPage();
	    Assert.assertTrue(isOnCreateClassesResult, "La page Create Classes doit ètre affichée");
	    
	    test.info("saisir un nom");
	    String nameValue = "Classes A";
	    createClasses.sendNameValue(nameValue);
	    
	    test.info("cliquer sur le bouton Create");
	    createClasses.clickOnCreateButton();
	    
	    test.info("Vérifier l'affichage du message d'erreur");
	    boolean isFirstErrorMessageDisplayedResult = createClasses.isFirstErrorMessageDisplayed();
	    Assert.assertTrue(isFirstErrorMessageDisplayedResult, "Le message d'erreur doit ètre affiché");
	    
	    test.info("vider le champ Name");
	    createClasses.clearNameField();
	    
	    test.info("Sélectionner un niveau");
	    String levelValue = "121";
	    createClasses.selectLevel(levelValue);
	    
	    test.info("cliquer sur le bouton Create");
	    createClasses.clickOnCreateButton();
	    
	    test.info("Vérifier l'affichage du message d'erreur");
	    boolean isSecondErrorMessageDisplayedResult = createClasses.isSecondErrorMessageDisplayed();
	    Assert.assertTrue(isSecondErrorMessageDisplayedResult, "Le message d'erreur doit ètre affiché");
	    
	}

}
