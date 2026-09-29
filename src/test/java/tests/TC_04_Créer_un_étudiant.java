package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DashboardPage;
import pages.createStudentsPage;
import pages.loginPage;
import pages.studentsPage;

public class TC_04_Créer_un_étudiant extends BaseTest {
	
	@Test
	public void testerLaCréationDunEtudiant() {
		loginPage Login = new loginPage(driver);
		DashboardPage dashboard = new DashboardPage(driver);
		studentsPage students = new studentsPage(driver);
		createStudentsPage createStudents = new createStudentsPage(driver);
		test=extent.createTest("TC04_Tester_la_création_étudiant");
		
		
		test.info("Se connecter");
	    Login.sendSchoolCode("neoschool");
	    Login.sendEmailAddress("admin@neoschool.test");
	    Login.sendPassword("edupassword!");
	    Login.clickOnSignInButton();
	    
	    test.info("cliquer sur Students");
	    dashboard.clickOnStudentsMenu();
	    
	    test.info("Vérifier l'affichage de la page Students");
	    boolean isOnStudentsResult = students.isOnStudentsPage();
	    Assert.assertTrue(isOnStudentsResult, "la page Students doit ètre afichée");
	    
	    test.info("Cliquer sur le bouton new Students");
	    students.clickOnNewStudentsButton();
	    
	    test.info("Vérifier l'affichage de la page Create Students");
	    boolean isOnCreateStudentsResult = createStudents.isOnCreateStudents();
	    Assert.assertTrue(isOnCreateStudentsResult, "La page Create Students doit ètre affichée");
	    
	    test.info("Saisir le prènom");
	    String firstName = "Ahmed";
	    createStudents.sendFirstName(firstName);
	    
	    test.info("Saisir le nom");
	    String lastName = "Askri";
	    createStudents.sendLastName(lastName);
	    
	    test.info("saisir la date de naissance");
	    createStudents.sendBirthDate("22" + "08" + "2016");
	    
	    test.info("sélectionner le sexe");
	    createStudents.clickOnGenderList();
	    createStudents.selectGender("m");
	    
	    test.info("charger une photo de profil");
	    String photoPath = "C:\\Users\\kawem\\Pictures\\photo de profil.png";
	    createStudents.uploadProfilePhoto(photoPath);
	    
	    test.info("Vérifier l'upload de la photo de profil");
	    boolean isProfilePhotoDisplayedResult = createStudents.isProfilePhotoDisplayed();
	    Assert.assertTrue(isProfilePhotoDisplayedResult, "La photo de profil doit ètre chargée");
	    
	    test.info("saisir le numéro d'admission");
	    String admissionNumberValue = "655";
	    createStudents.sendAdmissionNumberValue(admissionNumberValue);
	    
	    test.info("Cliquer sur le bouton Create");
	    createStudents.clickOnCreateButton();
	    
	    test.info("Vérifier l'affichage du message de confirmation");
	    boolean CreateMessageResult = students.isCreateMessageDisplayed();
	    Assert.assertTrue(CreateMessageResult, "Le message de confirmation doit ètre affiché");
	    
	    test.info("Vérifier la création de l'étudiant");
	    String fullName = firstName + " " + lastName;
	    boolean isStudentDisplayedResult = students.isStudentDisplayedInList(fullName);
	    Assert.assertTrue(isStudentDisplayedResult, "l'étudiant doit ètre affiché dans la liste");
	    
		
	}

}
