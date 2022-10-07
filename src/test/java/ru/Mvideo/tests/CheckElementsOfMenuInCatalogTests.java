package ru.Mvideo.tests;

import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.Mvideo.TestsConfiguration;
import ru.Mvideo.pages.MainPage;
import ru.Mvideo.testData.TestDataForCatalog;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class CheckElementsOfMenuInCatalogTests extends TestsConfiguration {
    MainPage mainPage = new MainPage();


    static Stream<Arguments> checkCatalogMenuTest() {
        TestDataForCatalog testDataForCatalog = new TestDataForCatalog();
        return Stream.of(
                Arguments.of(List.of(testDataForCatalog.catalogMenuElements))
        );
    }

    @MethodSource
    @DisplayName("Проверка элементов меню в каталоге сайта")
    @ParameterizedTest
    void checkCatalogMenuTest(List<String> expectedElementsOfCatalogMenu) {
        mainPage.openMainPage()
                .openCatalog()
                .checkElementsInCatalog(expectedElementsOfCatalogMenu);
    }

    static Stream<Arguments> checkCatalogMenuTestByProducts() {
        TestDataForCatalog testDataForCatalog = new TestDataForCatalog();
        return Stream.of(
                Arguments.of("Акции, скидки и распродажи", List.of(testDataForCatalog.salesElements)),
                Arguments.of("Смартфоны и гаджеты", List.of(testDataForCatalog.phonesElements)),
                Arguments.of("Ноутбуки и компьютеры", List.of(testDataForCatalog.computerElements)),
                Arguments.of("Телевизоры и цифровое ТВ", List.of(testDataForCatalog.tvElements)),
                Arguments.of("Аудиотехника", List.of(testDataForCatalog.audioTechniqueElements)),
                Arguments.of("Техника для кухни", List.of(testDataForCatalog.techniqueForKitchenElements)),
                Arguments.of("Техника для дома", List.of(testDataForCatalog.techniqueForHomeElements))
        );
    }

    @MethodSource
    @ParameterizedTest(name = "Проверка элементов Меню  \"{0}\" в каталоге сайта")
    void checkCatalogMenuTestByProducts(String product, List<String> expectedElementsOfInProductCatalogMenu) {
        mainPage.openMainPage()
                .openCatalog()
                .selectProductFromCatalog(product)
                .checkElementsOfMenuInCatalog(expectedElementsOfInProductCatalogMenu);
    }
}
