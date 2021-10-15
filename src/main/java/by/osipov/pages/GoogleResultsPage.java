package by.osipov.pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$x;

public class GoogleResultsPage extends BasePage {
    /**
     * Получение результатов поискового запроса
     */
    public ElementsCollection results() {
        return $$x("//div[@class='yuRUbf']");
    }
}
