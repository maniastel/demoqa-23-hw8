package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import data.TestData;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static io.qameta.allure.Allure.step;

@Tag("form")
public class FormTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @Feature("Student Registration Form")
    @Story("Регистрация нового пользователя")
    @Owner("mstelmakh")
    @Tag("Critical")
    @DisplayName("Успешная регистрация нового пользователя")
    void successfulRegistrationTest() {

        TestData data = new TestData();
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем страницу регистрации", () ->
                registrationPage.openPage());
        step("Заполняем поле First name", () ->
                registrationPage.fillFirstName(data.firstName));
        step("Заполняем поле Last name", () ->
                registrationPage.fillLastName(data.lastName));
        step("Заполняем поле Email", () ->
                registrationPage.fillUserEmail(data.email));
        step("Выбираем пол", () ->
                registrationPage.selectGender(data.gender));
        step("Заполняем поле Phone", () ->
                registrationPage.fillUserNumber(data.phone));
        step("Выбираем дату рождения", () ->
                registrationPage.setDateOfBirth(data.day, data.month, data.year));
        step("Выбираем предмет", () ->
                registrationPage.fillSubject(data.subject));
        step("Выбираем хобби", () ->
                registrationPage.selectHobby(data.hobby));
        step("Загружаем изображение", () ->
                registrationPage.uploadPicture("picture.png"));
        step("Заполняем адрес", () ->
                registrationPage.fillCurrentAddress(data.address));
        step("Выбираем штат", () ->
                registrationPage.fillState(data.state));
        step("Выбираем город", () ->
                registrationPage.fillCity(data.city));
        step("Отправляем форму", () ->
                registrationPage.sendForm());


        //form data check
        step("Проверяем отображение попапа", () ->
                registrationPage.checkModalDisplay());
        step("Проверяем имя и фамилию", () ->
                registrationPage.checkResult("Student Name", data.firstName + " " + data.lastName));
        step("Проверяем email", () ->
                registrationPage.checkResult("Student Email", data.email));
        step("Проверяем пол", () ->
                registrationPage.checkResult("Gender", data.gender));
        step("Проверяем номер телефона", () ->
                registrationPage.checkResult("Mobile", data.phone));
        step("Проверяем дату рождения", () ->
                registrationPage.checkResult("Date of Birth", data.day + " " + data.month + "," + data.year));
        step("Проверяем предмет", () ->
               registrationPage.checkResult("Subjects", data.subject));
        step("Проверяем хобби", () ->
                registrationPage.checkResult("Hobbies", data.hobby));
        step("Проверяем изображение", () ->
                registrationPage.checkResult("Picture", "picture.png"));
        step("Проверяем адрес", () ->
                registrationPage.checkResult("Address", data.address));
        step("Проверяем штат и город", () ->
                registrationPage.checkResult("State and City", data.state + " " + data.city));


    }

    @Test
    @Feature("Student Registration Form")
    @Story("Регистрация нового пользователя")
    @Owner("mstelmakh")
    @Tag("Blocker")
    @DisplayName("Успешная регистрация нового пользователя c минимальным количеством заполненных полей")
    void successfullRegistrationTestWitMinimalFilledFields() {

        TestData data = new TestData();
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем страницу регистрации", () ->
                registrationPage.openPage());
        step("Заполняем поле First name", () ->
                registrationPage.fillFirstName(data.firstName));
        step("Заполняем поле Last name", () ->
                registrationPage.fillLastName(data.lastName));
        step("Выбираем пол", () ->
                registrationPage.selectGender(data.gender));
        step("Заполняем поле Phone", () ->
                registrationPage.fillUserNumber(data.phone));
        step("Отправляем форму", () ->
                registrationPage.sendForm());

        //form data check
        step("Проверяем отображение попапа", () ->
                registrationPage.checkModalDisplay());
        step("Проверяем имя и фамилию", () ->
                registrationPage.checkResult("Student Name", data.firstName + " " + data.lastName));
        step("Проверяем пол", () ->
                registrationPage.checkResult("Gender", data.gender));
        step("Проверяем номер телефона", () ->
                registrationPage.checkResult("Mobile", data.phone));


    }

    @Test
    @Feature("Student Registration Form")
    @Story("Регистрация нового пользователя")
    @Owner("mstelmakh")
    @Tag("Blocker")
    @DisplayName("Регистрация нового пользователя без заполнения поля Phone")
    void RegistrationTestWithoutMobileField() {

        TestData data = new TestData();
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем страницу регистрации", () ->
                registrationPage.openPage());
        step("Заполняем поле First name", () ->
                registrationPage.fillFirstName(data.firstName));
        step("Заполняем поле Last name", () ->
                registrationPage.fillLastName(data.lastName));
        step("Заполняем поле Email", () ->
                registrationPage.fillUserEmail(data.email));
        step("Выбираем пол", () ->
                registrationPage.selectGender(data.gender));
        step("Выбираем дату рождения", () ->
                registrationPage.setDateOfBirth(data.day, data.month, data.year));
        step("Выбираем предмет", () ->
                registrationPage.fillSubject(data.subject));
        step("Выбираем хобби", () ->
                registrationPage.selectHobby(data.hobby));
        step("Загружаем изображение", () ->
                registrationPage.uploadPicture("picture.png"));
        step("Заполняем адрес", () ->
                registrationPage.fillCurrentAddress(data.address));
        step("Выбираем штат", () ->
                registrationPage.fillState(data.state));
        step("Выбираем город", () ->
                registrationPage.fillCity(data.city));
        step("Отправляем форму", () ->
                registrationPage.sendForm());

        step("Проверяем, что попапа нет", () ->
                registrationPage.checkModalIsNotDisplayed());
        step("Проверяем, что поле Phone подсвечено красным", () ->
                registrationPage.checkMobileInputIsRed());

    }

}
