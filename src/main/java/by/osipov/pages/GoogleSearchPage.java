package by.osipov.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class GoogleSearchPage extends BasePage{
    /**
     * Ищет по заданному запросу
     * @param query запрос
     */
    public GoogleResultsPage search(String query) {
        $(By.name("q")).setValue(query).pressEnter();
        return page(GoogleResultsPage.class);
    }
}
