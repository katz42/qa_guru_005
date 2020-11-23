import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byPartialLinkText;
import static com.codeborne.selenide.Selenide.*;

class testingExecuteJavascript {
    @Test
    void findSelenideWithJavascript () {

        // Открыть Яндекс
        open("http://www.yandex.ru/");

        // Ввести в поиск Selenide
        $(byName("text")).shouldBe(visible);
        executeJavaScript("text.value = 'Selenide'");
        $(byName("text")).pressEnter();

        // Проверить, что в поиске есть сайт org.selenide.ru
        $(byPartialLinkText("org.selenide.ru"));
    }
}