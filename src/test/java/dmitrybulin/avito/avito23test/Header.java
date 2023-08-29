package dmitrybulin.avito.avito23test;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

// page_url = https://www.avito.ru/*
public class Header {
    public SelenideElement favoritesButton = $("[data-marker='header/favorites']");
}
