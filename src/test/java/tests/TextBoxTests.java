package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

import static io.qameta.allure.Allure.step;

@Tag("textbox")
public class TextBoxTests extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    @Feature("Text Box")
    @Story("Отправка формы")
    @Owner("mstelmakh")
    @Tag("Critical")
    @DisplayName("Успешная отправка формы")
    void successfulFormSendTest() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем страницу с формой", () ->
                textBoxPage.openPage());
        step("Заполняем поле Full name", () ->
                textBoxPage.fillUserName("Olga Black"));
        step("Заполняем поле Email", () ->
                textBoxPage.fillUserEmail("oblack@mail.com"));
        step("Заполняем адрес места проживания", () ->
                textBoxPage.fillCurrentAddress("11 Street, Boston, USA"));
        step("Заполняем адрес прописки", () ->
                textBoxPage.fillPermanentAddress("89 Big Row, NY, USA"));
        step("Отправляем форму", () ->
                textBoxPage.sendForm());


        //check data
        step("Проверяем полное имя", () ->
                textBoxPage.checkResult("Name","Olga Black"));
        step("Проверяем email", () ->
                textBoxPage.checkResult("Email", "oblack@mail.com"));
        step("Проверяем адрес проживания", () ->
                textBoxPage.checkResult("Current Address", "11 Street, Boston, USA"));
        step("Проверяем адрес прописки", () ->
                textBoxPage.checkResult("Permananet Address", "89 Big Row, NY, USA"));

    }
}
