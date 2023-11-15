package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResponseTableComponent {

    private final SelenideElement resultTable = $(".table-responsive");

    public void checkTableModalIsAppeared() {
        $(".modal-content").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    }

    public void checkTableContent(String key, String value) {
        resultTable.$(byText(key)).parent().shouldHave(text(value));
    }

    public void checkTableModalIsNotAppeared() {
        $(".modal-content").shouldNot(appear);
    }
}
