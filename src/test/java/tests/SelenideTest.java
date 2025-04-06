package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideTest {

    @DisplayName("Проверка наличие Issue с текстом: Kotlin")
    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open(TestData.BASE_URL);
        $("[placeholder='Search or jump to...']").click();
        $("#query-builder-test").setValue(TestData.REPO).pressEnter();
        $(linkText(TestData.REPO_FULL_NAME)).click();
        $("#issues-tab").click();
        $(withText(TestData.ISSUE_TEXT)).should(Condition.exist);
    }
}
