package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {

    @BeforeEach
    public void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @DisplayName("Проверка наличие Issue с текстом: Kotlin")
    @Test
    public void testIssueSearch() {
        openGitHubMainPage();
        searchForRepository(TestData.REPO);
        openRepository(TestData.REPO_FULL_NAME);
        openIssuesTab();
        shouldSeeIssueWithText(TestData.ISSUE_TEXT);
    }

    @Step("Открыть главную страницу GitHub")
    public void openGitHubMainPage() {
        open(TestData.BASE_URL);
    }

    @Step("Выполнить поиск по репозиторию: {repo}")
    public void searchForRepository(String repo) {
        $("[placeholder='Search or jump to...']").click();
        $("#query-builder-test").setValue(repo).pressEnter();
    }

    @Step("Открыть репозиторий: {repoFullName}")
    public void openRepository(String repoFullName) {
        $(linkText(repoFullName)).click();
    }

    @Step("Открыть вкладку Issues")
    public void openIssuesTab() {
        $("#issues-tab").click();
    }

    @Step("Проверить наличие Issue с текстом: {issueText}")
    public void shouldSeeIssueWithText(String issueText) {
        $(withText(issueText)).should(Condition.exist);
    }
}
