package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;

public class WebStepsTest extends TestBase {

    @DisplayName("Проверка наличие Issue с текстом: Kotlin")
    @Test
    public void testIssueSearch() {
        openGitHubMainPage();
        searchForRepository(REPO);
        openRepository(REPO_FULL_NAME);
        openIssuesTab();
        shouldSeeIssueWithText(ISSUE_TEXT);
    }

    @Step("Открыть главную страницу GitHub")
    public void openGitHubMainPage() {
        open(BASE_URL);
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
