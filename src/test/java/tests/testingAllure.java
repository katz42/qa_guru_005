package tests;

import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;


class testingAllure {
    @Test
    void findSelenide() {
        addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));

        // Open Yandex
        open("http://www.yandex.ru");

        // Search for Selenide
        $(byName("text")).setValue("Selenide").pressEnter();

        // Make sure results have "ru.selenide.org" page
        $("html").shouldHave(text("ru.selenide.org"));
    }
}
