package tests;

import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static io.qameta.allure.Allure.step;


class testingAllure {
    @Test
    void findSelenide() {
        addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));

        String textForSearch = "Selenide";

        step("Open Yandex  // Открыть Яндекс", ()->
        open("http://www.yandex.ru")
        );

        step ("Search for " + textForSearch + " // Ввести в поиск " + textForSearch + "", ()->
        $(byName("text")).setValue(textForSearch).pressEnter()
        );

        step ("Make sure results have ru.selenide.org page // Убедиться, что в выдаче есть сайт ru.selenide.org", ()->
        $("html").shouldHave(text("ru.selenide.org"))
        );
    }
}
