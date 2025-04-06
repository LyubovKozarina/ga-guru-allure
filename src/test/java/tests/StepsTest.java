package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepsTest {

    @DisplayName("Проверка наличие Issue с текстом: Kotlin")
    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открыть главную страницу GitHub", () -> open(TestData.BASE_URL));
        step("Нажать на поле поиска", () -> $("[placeholder='Search or jump to...']").click());
        step("Ввести '" + TestData.REPO + "' в поле поиска", () ->
                $("#query-builder-test").setValue(TestData.REPO).pressEnter());
        step("Перейти на страницу репозитория '" + TestData.REPO_FULL_NAME + "'", () ->
                $(linkText(TestData.REPO_FULL_NAME)).click());
        step("Перейти в раздел Issues", () -> $("#issues-tab").click());
        step("Проверить наличие Issue с текстом '" + TestData.ISSUE_TEXT + "'", () ->
                $(withText(TestData.ISSUE_TEXT)).should(Condition.exist));
    }
}
