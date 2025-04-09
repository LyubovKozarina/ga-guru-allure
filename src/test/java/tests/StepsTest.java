package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepsTest extends TestBase {

    @DisplayName("Проверка наличие Issue с текстом: Kotlin")
    @Test
    public void testIssueSearch() {

        step("Открыть главную страницу GitHub", () -> open(BASE_URL));
        step("Нажать на поле поиска", () -> $("[placeholder='Search or jump to...']").click());
        step("Ввести '" + REPO + "' в поле поиска", () ->
                $("#query-builder-test").setValue(REPO).pressEnter());
        step("Перейти на страницу репозитория '" + REPO_FULL_NAME + "'", () ->
                $(linkText(REPO_FULL_NAME)).click());
        step("Перейти в раздел Issues", () -> $("#issues-tab").click());
        step("Проверить наличие Issue с текстом '" + ISSUE_TEXT + "'", () ->
                $(withText(ISSUE_TEXT)).should(exist));
    }
}
