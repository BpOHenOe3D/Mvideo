package ru.Mvideo.tests;

import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.Mvideo.TestsConfiguration;
import ru.Mvideo.pages.MainPage;
import ru.Mvideo.testData.TestDataForMainPage;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class MainPageTests extends TestsConfiguration {

    MainPage mainPage = new MainPage();

    static Stream<Arguments> checkHeaderMenuTestFirstHalf() {
        TestDataForMainPage testDataForMainPage = new TestDataForMainPage();
        return Stream.of(
                Arguments.of(List.of(testDataForMainPage.firstHalfElementsOfHeaderMenu))
        );
    }

    @MethodSource
    @ParameterizedTest
    @DisplayName("Проверка первой половины меню в хедере сайта")
    void checkHeaderMenuTestFirstHalf(List<String> expectedFirstElementsOfHeaderMenu) {
        mainPage.openMainPage()
                .checkElementsInHeaderOfMainPage(expectedFirstElementsOfHeaderMenu);
    }

    static Stream<Arguments> checkHeaderMenuTestSecondHalf() {
        TestDataForMainPage testDataForMainPage = new TestDataForMainPage();
        return Stream.of(
                Arguments.of(List.of(testDataForMainPage.secondHalfElementsOfHeaderMenu))
        );
    }

    @MethodSource
    @ParameterizedTest
    @DisplayName("Проверка второй половины меню в хедере сайта")
    void checkHeaderMenuTestSecondHalf(List<String> expectedSecondElementsOfHeaderMenu) {
        mainPage.openMainPage();
        step("Прокручиваем первую половину меню", () -> {
            $(".slide-panel__btn--right").click();
        });
        mainPage.checkElementsInHeaderOfMainPage(expectedSecondElementsOfHeaderMenu);
    }
}
