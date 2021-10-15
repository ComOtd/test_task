package by.osipov.pages;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class MainPage extends BasePage{
    /**
     * Нажимает на "Подобрать по параметрам"
     */
    public MarketplaceFilterPage clickOnMarketplaceFilterButton(){
        $(byText("Подобрать по параметрам")).parent().click();
        return page(MarketplaceFilterPage.class);
    }

    /**
     * Закрывает предупреждение о Cookie
     */
    public MainPage closeCookieWarning(){
        $(byText("Закрыть")).click();
        return this;
    }
}
