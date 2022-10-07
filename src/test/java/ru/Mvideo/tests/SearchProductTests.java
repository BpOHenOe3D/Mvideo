package ru.Mvideo.tests;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.Mvideo.TestsConfiguration;
import ru.Mvideo.pages.MainPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class SearchProductTests extends TestsConfiguration {

    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Поиск Iphone через поисковою строку")
    void findProductInSearBarTest() {
        mainPage.openMainPage();
        step("Вводим iPhone в поисковую строку и нажимаем enter", () -> {
            $(".input__field").setValue("iphone").pressEnter();
        });
        step("Проверяем что открылся результат поиска по iPhone", () -> {
            $(".plp__current-category").shouldHave(text("iPhone"));
        });
    }

    @Test
    @DisplayName("Поиск Iphone через каталог")
    void findProductInCatalogTest() {
        mainPage.openMainPage()
                .openCatalog()
                .selectProductFromCatalog("Смартфоны и гаджеты");
        step("Выбор iPhone из списка смартфонов", () -> {
            $(".main-links").$(byText("Apple iPhone")).click();
        });
        step("Проверяем что открылся результат поиска по iPhone", () -> {
            $(".plp__current-category").shouldHave(text("iPhone"));
        });

    }
}
