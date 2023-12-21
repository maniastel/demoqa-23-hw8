package tests;

import com.codeborne.selenide.Configuration;
import helpers.Attachments;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
//        Configuration.browser = "chrome";
       Configuration.timeout = 10000;
//        Configuration.holdBrowserOpen = true;
       Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

       DesiredCapabilities capabilities = new DesiredCapabilities();
       capabilities.setCapability("selenoid:options", Map.<String, Object>of(
               "enableVNC", true,
               "enableVideo", true
       ));
       Configuration.browserCapabilities = capabilities;

    }

    @AfterEach
    void addAttachments() {
        Attachments.screenshotAs("Last screenshot");
        Attachments.pageSource();
        Attachments.browserConsoleLogs();
        Attachments.addVideo();

    }
}
