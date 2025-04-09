package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideTest extends TestBase {

    @Test
    @DisplayName("Проверка наличия Issue с текстом: Kotlin")
    public void testIssueSearch() {

        open(BASE_URL);
        $("[placeholder='Search or jump to...']").click();
        $("#query-builder-test").setValue(REPO).pressEnter();
        $(linkText(REPO_FULL_NAME)).click();
        $("#issues-tab").click();
        $(withText(ISSUE_TEXT)).should(Condition.exist);
    }
}
