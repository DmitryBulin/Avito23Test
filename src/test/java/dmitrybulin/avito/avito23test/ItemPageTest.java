package dmitrybulin.avito.avito23test;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.chrome.ChromeOptions;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ItemPageTest {
    ItemPage itemPage = new ItemPage();
    Header header = new Header();
    static String baseUrl = "https://www.avito.ru/";

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x1080";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/SampleItems.csv", useHeadersInDisplayName = true)
    public void favoriteItem(String itemId)
    {
        String itemUrl = getItemUrl(itemId);
        open(itemUrl);

        itemPage.favoriteItemButton.click();
        header.favoritesButton.click();

        String itemSelector = String.format("div[data-marker='item-%s'", itemId);
        $(itemSelector).shouldBe(visible);
    }

    private static String getItemUrl(String itemId)
    {
        return String.format("%s/%s", baseUrl, itemId);
    }
}
