package tests;

import data.TestData;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class FormTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {

        TestData data = new TestData();

        registrationPage.openPage()
                .fillFirstName(data.firstName)
                .fillLastName(data.lastName)
                .fillUserEmail(data.email)
                .selectGender(data.gender)
                .fillUserNumber(data.phone)
                .setDateOfBirth(data.day, data.month, data.year)
                .fillSubject(data.subject)
                .selectHobby(data.hobby)
                .uploadPicture("picture.png")
                .fillCurrentAddress(data.address)
                .fillState(data.state)
                .fillCity(data.city)
                .sendForm();

        //form data check
        registrationPage.checkModalDisplay()
                .checkResult("Student Name", data.firstName + " " + data.lastName)
                .checkResult("Student Email", data.email)
                .checkResult("Gender", data.gender)
                .checkResult("Mobile", data.phone)
                .checkResult("Date of Birth", data.day + " " + data.month + "," + data.year)
                .checkResult("Subjects", data.subject)
                .checkResult("Hobbies", data.hobby)
                .checkResult("Picture", "picture.png")
                .checkResult("Address", data.address)
                .checkResult("State and City", data.state + " " + data.city);

    }

    @Test
    void successfullRegistrationTestWitMinimalFilledFields() {

        TestData data = new TestData();

        registrationPage.openPage()
                .fillFirstName(data.firstName)
                .fillLastName(data.lastName)
                .selectGender(data.gender)
                .fillUserNumber(data.phone)
                .sendForm();

        //form data check
        registrationPage.checkModalDisplay()
                .checkResult("Student Name", data.firstName + " " + data.lastName)
                .checkResult("Gender", data.gender)
                .checkResult("Mobile", data.phone);


    }

    @Test
    void RegistrationTestWithoutMobileField() {

        TestData data = new TestData();

        registrationPage.openPage()
                .fillFirstName(data.firstName)
                .fillLastName(data.lastName)
                .fillUserEmail(data.email)
                .selectGender(data.gender)
                .setDateOfBirth(data.day, data.month, data.year)
                .fillSubject(data.subject)
                .selectHobby(data.hobby)
                .uploadPicture("picture.png")
                .fillCurrentAddress(data.address)
                .fillState(data.state)
                .fillCity(data.city)
                .sendForm();

        registrationPage.checkModalIsNotDisplayed()
                .checkMobileInputIsRed();
    }

}
