package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DashboardPage;
import pages.createTeachersPage;
import pages.loginPage;
import pages.teachersPage;

public class TC_05_Créer_un_enseignant extends BaseTest {
	
	@Test
	
	public void testerLaCréationDunEnseignant() {
		loginPage Login = new loginPage(driver);
		DashboardPage dashboard = new DashboardPage(driver);
		teachersPage teachers = new teachersPage(driver);
		createTeachersPage createTeachers = new createTeachersPage(driver);
		test=extent.createTest("TC05_Tester_la_création_ensignant");
		
		
		test.info("Se connecter");
	    Login.sendSchoolCode("neoschool");
	    Login.sendEmailAddress("admin@neoschool.test");
	    Login.sendPassword("edupassword!");
	    Login.clickOnSignInButton();
	    
	    test.info("cliquer sur le menu Teachers");
	    dashboard.clickOnTeachersMenu();
	    
	    test.info("Vérifier l'affichage de la page Teachers");
	    boolean isOnTeachersResult = teachers.isOnTeachersPage();
	    Assert.assertTrue(isOnTeachersResult, "la page Teachers doit ètre afichée");
	    
	    test.info("Cliquer sur le bouton New Teachers");
	    teachers.clickOnNewTeachersButton();
	    
	    test.info("Vérifier l'affichage de la page Create Teachers");
	    boolean isOnCreateTeachersResult = createTeachers.isOnCreateTeachers();
	    Assert.assertTrue(isOnCreateTeachersResult, "La page Create Teachers doit ètre affichée");
	    
	    test.info("Saisir le prènom");
	    String firstName = "Mohamed";
	    createTeachers.sendFirstName(firstName);
	    
	    test.info("Saisir le nom");
	    String lastName = "Ben Salah";
	    createTeachers.sendLastName(lastName);
	    
	    test.info("saisir la date de naissance");
	    createTeachers.sendBirthDate("12" + "05" + "1985");
	    
	    test.info("Saisir email");
	    String email = "mohamedbensalah@futureacademy.com";
	    createTeachers.sendEmailValue(email); 
	    
	    test.info("sélectionner le sexe");
	    createTeachers.clickOnGenderList();
	    createTeachers.selectGender("m");
	    
	    test.info("Saisir le numéro de téléphone");
	    String phoneNumber = "+21659595959";
	    createTeachers.sendPhoneNumberValue(phoneNumber);
	    
	    test.info("Saisir le code postal");
	    String postalCode = "2000";
	    createTeachers.sendPostalCodeValue(postalCode);
	    
	    test.info("Saisir l'adresse");
	    String address = "31 rue picaso";
	    createTeachers.sendAdressValue(address);
	    
	    test.info("sélectionner la status");
	    createTeachers.clickOnStatusList();
	    createTeachers.selectStatus("active");
	    
	    test.info("Vérifier que le numéro d'employer est  renseigné par défaut par le système");
	    boolean employeeNumber = createTeachers.isEmployeeNumberDisplayed();
	    Assert.assertTrue(employeeNumber, "le numéro d'employer doit ètre  renseigné par défaut par le système");
	    
	    test.info("charger une photo de profil");
	    String photoPath = "C:\\Users\\kawem\\Pictures\\photo de profil.png";
	    createTeachers.uploadProfilePhoto(photoPath);
	    
	    test.info("Vérifier l'upload de la photo de profil");
	    boolean isProfilePhotoDisplayedResult = createTeachers.isProfilePhotoDisplayed();
	    Assert.assertTrue(isProfilePhotoDisplayedResult, "La photo de profil doit ètre chargée");
	    
	    test.info("Cliquer sur le bouton Create");
	    createTeachers.clickOnCreateButton();
	    
	    test.info("Vérifier l'affichage du message de confirmation");
	    boolean CreateMessageResult = teachers.isCreateMessageDisplayed();
	    Assert.assertTrue(CreateMessageResult, "Le message de confirmation doit ètre affiché");
	    
	    test.info("Vérifier la création de l'enseignant");
	    String fullName = firstName + " " + lastName;
	    boolean isTeacherDisplayedResult = teachers.isTacherDisplayedInList(fullName, phoneNumber);
	    Assert.assertTrue(isTeacherDisplayedResult, "l'enseignant doit ètre affiché dans la liste");
	}
	
}
