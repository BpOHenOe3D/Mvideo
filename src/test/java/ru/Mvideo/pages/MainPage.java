package ru.Mvideo.pages;


import com.codeborne.selenide.CollectionCondition;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    @Step("Открыть главную страницу")
    public MainPage openMainPage() {
        open("https://www.mvideo.ru/");
        return this;
    }

    @Step("Открыть каталог")
    public MainPage openCatalog() {
        $(".catalog-button").click();
        return this;
    }

    @Step("Выбор продукта из списка")
    public MainPage selectProductFromCatalog(String product) {
        $(".left-menu").$(byText(product)).hover();
        return this;
    }

    @Step("Проверка наличия элементов меню в списке каталога")
    public MainPage checkElementsInCatalog(List<String> expectedElementsOfCatalogMenu) {
        $$(".left-menu").shouldHave(CollectionCondition.texts(expectedElementsOfCatalogMenu));
        return this;
    }

    @Step("Проверка наличия элементов меню в хедере главной страницы ")
    public MainPage checkElementsInHeaderOfMainPage(List<String> expectedElementsOfHeaderMenu) {
        $$(".app-header-bottom").shouldHave(CollectionCondition.texts(expectedElementsOfHeaderMenu));
        return this;
    }

    @Step("Проверка наличия элементов меню в списке каталога ")
    public MainPage checkElementsOfMenuInCatalog(List<String> expectedElementOfMenuInCatalog) {
        $$(".main-links").shouldHave(CollectionCondition.texts(expectedElementOfMenuInCatalog));
        return this;
    }
}
