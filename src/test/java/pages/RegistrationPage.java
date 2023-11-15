package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResponseTableComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    CalendarComponent calendar = new CalendarComponent();
    ResponseTableComponent table = new ResponseTableComponent();
    private final SelenideElement firstNameInput = $("#firstName"),
                            lastNameInput = $("#lastName"),
                            userEmailInput = $("#userEmail"),
                            genderWrapper = $("#genterWrapper"),
                            userNumberInput = $("#userNumber"),
                            calendarInput = $("#dateOfBirthInput"),
                            subjectInput = $("#subjectsInput"),
                            hobbyWrapper = $("#hobbiesWrapper"),
                            uploadPictureInput = $("#uploadPicture"),
                            addressInput = $("#currentAddress"),
                            stateInput = $("#react-select-3-input"),
                            cityInput = $("#react-select-4-input"),
                            submitButton = $("#submit");

    public RegistrationPage  openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage  fillFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage  fillLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage  fillUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage  selectGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage  fillUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage  setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendar.setDate(day, month, year);

        return this;
    }

    public RegistrationPage fillSubject(String value) {
        subjectInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage  selectHobby(String value) {
        hobbyWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage  uploadPicture(String value) {
        uploadPictureInput.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage  fillCurrentAddress(String value) {
        addressInput.setValue(value);

        return this;
    }

    public RegistrationPage fillState(String value) {
        stateInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage fillCity(String value) {
        cityInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage sendForm() {
        submitButton.click();

        return this;
    }

    public RegistrationPage checkModalDisplay() {
        table.checkTableModalIsAppeared();

        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        table.checkTableContent(key,value);

        return this;

    }

    public RegistrationPage checkModalIsNotDisplayed() {
        table.checkTableModalIsNotAppeared();

        return this;
    }

    public RegistrationPage checkMobileInputIsRed() {
        userNumberInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        return this;
    }



}
