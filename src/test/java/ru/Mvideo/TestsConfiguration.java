package ru.Mvideo;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import ru.Mvideo.helpers.AllureAttach;
import ru.Mvideo.helpers.DriverConfiguration;

public class TestsConfiguration {

    @BeforeAll
    static void settings() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DriverConfiguration.configure();
    }

    @AfterEach
    void addAttachments() {
        AllureAttach.screenshotAs("Screenshot");
        AllureAttach.pageSource();
        AllureAttach.browserConsoleLogs();
        if ((System.getProperty("selenide.remote") != null)) {
            AllureAttach.addVideo();
        }
    }
}
