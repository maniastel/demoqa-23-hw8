package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTests extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void successfulFormSendTest() {

        textBoxPage.openPage()
                .fillUserName("Olga Black")
                .fillUserEmail("oblack@mail.com")
                .fillCurrentAddress("11 Street, Boston, USA")
                .fillPermanentAddress("89 Big Row, NY, USA")
                .sendForm();

        //check data
        textBoxPage.checkResult("Name","Olga Black")
                .checkResult("Email", "oblack@mail.com")
                .checkResult("Current Address", "11 Street, Boston, USA")
                .checkResult("Permananet Address", "89 Big Row, NY, USA");
    }
}
