package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DashboardPage;
import pages.classesPage;
import pages.createClassesPage;
import pages.createdClassePage;
import pages.loginPage;

public class TC_08_Créer_une_classe_avec_des_informations_valides extends BaseTest {
	
	@Test
	
	public void TesterLaCréationDuneClasseAvecDesInformationsValides() {
		
		loginPage login = new loginPage(driver);
		DashboardPage dashboard = new DashboardPage(driver);
		classesPage classes = new classesPage(driver);
		createClassesPage createClasses = new createClassesPage(driver);
		createdClassePage createdClasse = new createdClassePage(driver);

		test=extent.createTest("TC_08_Créer_Une_Classe_Avec_Des_Informations_Valides");
		
		
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
	    
	    test.info("cliquer sur le champ des niveaux");
	    createClasses.clickOnLevelField();
	    
	    test.info("Vérifier que Le niveau qui a été crée dans le TC-06 s'affiche 'Niveau 1'");
	    String levelName = "Niveau 1";
	    boolean isLevelDisplayedResult = createClasses.isLevelOptionDisplayed(levelName);
	    Assert.assertTrue(isLevelDisplayedResult, "Le niveau qui a été crée dans le TC-06 'Niveau 1' doit s'afficher");
	    
	    test.info("Sélectionner un niveau");
	    String levelValue = "121";
	    createClasses.selectLevel(levelValue);
	    
	    test.info("saisir un nom");
	    String classeName = "Classes D";
	    createClasses.sendNameValue(classeName);
	    	    
	    test.info("cliquer sur le bouton Create");
	    createClasses.clickOnCreateButton();
	    
	    test.info("Vérifier l'affichage du message de confirmation");
	    boolean isCofirmationMessageDisplayedResult = createdClasse.isCreateMessageDisplayed();
	    Assert.assertTrue(isCofirmationMessageDisplayedResult, "le message de confirmation de création doit ètre affiché");
	    
	    test.info("cliquer sur Classes");
	    createdClasse.clickOnClassesMenu();
	    
	    test.info("Vérifier que la classe apparait dans la liste");
	    boolean isClasseOnListResult = classes.isClasseDisplayedInList(levelName, classeName);
	    Assert.assertTrue(isClasseOnListResult, "la classe doit apparaitre dans la liste");
	    
	    
	}

}
