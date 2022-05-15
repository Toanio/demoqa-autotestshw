package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestsWithAnnotation {

    @BeforeEach
    void setUp() {
        Configuration.holdBrowserOpen = false;
        Configuration.baseUrl = "https://store.my.games";
        Configuration.browserSize = "1920x1080";
    }
    @AfterEach
    void close() {
        Selenide.closeWebDriver();
    }

    @ValueSource(strings = {
            "Warface",
            "Крушители Подземелий"
    })

    @DisplayName("Test search with Value Source")
    @Tag("Search")
    @ParameterizedTest(name = "Проверка поиска в store.my.games по слову {0}")
    void searchGameWithValueSource(String testData) {
        open("/");
        $(".ph-menu__icon.ph-menu__icon_search").click();
        $("#ph-search").setValue(testData);
        $(".ph-search-result__title").shouldHave(text(testData));
    }

    @CsvSource(value = {
            "Arm, Armored Warfare",
            "Lost, LOST ARK"
    })
    @DisplayName("Test search with Csv Source")
    @Tag("Search")
    @ParameterizedTest(name = "Проверка поиска в store.my.games по слову {0}, ожидаем результат: {1}")
    void searchGameWithCsvSource(String testData, String expectedResult) {
        open("/");
        $(".ph-menu__icon.ph-menu__icon_search").click();
        $("#ph-search").setValue(testData);
        $(".ph-search-result__title").shouldHave(text(expectedResult));
    }

    static Stream<Arguments> methodSourceExampleTest() {
        return Stream.of(
                Arguments.of("Крушители", "Крушители Подземелий")
        );
    }
    @DisplayName(" search with Method Source")
    @MethodSource("methodSourceExampleTest")
    @Tag("Search")
    @ParameterizedTest(name = "Проверка поиска в store.my.games по слову {0}, ожидаем результат: {1}")
    void searchGameWithMethodSource(String first, String second) {
        open("/");
        $(".ph-menu__icon.ph-menu__icon_search").click();
        $("#ph-search").setValue(first);
        $(".ph-search-result__title").shouldHave(text(second));
    }



    @EnumSource(MenuItem.class)
    @Tag("Search")
    @DisplayName("Test search with Enum")
    @ParameterizedTest()
    void searchGameWithEnum(MenuItem testData) {
        open("/");
        $(".ph-menu__icon.ph-menu__icon_search").click();
        $("#ph-search").setValue("Круш");
        $(".ph-search-result__title").shouldHave(text(testData.rusName));
    }

}
