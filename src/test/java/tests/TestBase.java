package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {
    protected static final String BASE_URL = "https://github.com";
    protected static final String REPO = "selenide";
    protected static final String REPO_FULL_NAME = "selenide/selenide";
    protected static final String ISSUE_TEXT = "Kotlin";

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = BASE_URL;
        Configuration.browserSize = "1920x1080";
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void afterEach() {
        Selenide.closeWebDriver();
    }
}
