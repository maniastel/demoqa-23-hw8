package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {

    private final SelenideElement userNameInput = $("#userName"),
                            userEmailInput = $("#userEmail"),
                            currentAddressInput = $("#currentAddress"),
                            permanentAddressInput = $("#permanentAddress"),
                            submitButton = $("#submit"),
                            resultBox = $("#output");


    public TextBoxPage openPage() {

        open("/text-box");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public TextBoxPage fillUserName (String value) {
        userNameInput.setValue(value);

        return this;
    }

    public TextBoxPage fillUserEmail (String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public TextBoxPage fillCurrentAddress (String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public TextBoxPage fillPermanentAddress (String value) {
        permanentAddressInput.setValue(value);

        return this;
    }

    public TextBoxPage sendForm() {
        submitButton.click();

        return this;
    }

    public TextBoxPage checkResult(String key, String value) {
        resultBox.$(withText(key)).shouldHave(text(value));

        return this;
    }


}
