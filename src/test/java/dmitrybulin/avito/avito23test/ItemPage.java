package dmitrybulin.avito.avito23test;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

// page_url = https://www.avito.ru/{itemId}
public class ItemPage {
    public SelenideElement favoriteItemButton = $("div[class='style-header-add-favorite-M7nA2']");
}
