package by.osipov;

import by.osipov.pages.*;
import org.junit.jupiter.api.Test;

import static by.osipov.pages.BasePage.at;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class MarketplaceFilterTest {
    @Test
    public void carBrandTest() {
        open("https://www.google.com/", GoogleSearchPage.class)
                .search("СберЛизинг")
                .results()
                .first()
                .click();

        at(MainPage.class).closeCookieWarning()
                .clickOnMarketplaceFilterButton();

        at(MarketplaceFilterPage.class)
                .selectDropDownValue("Марка", "BMW")
                .selectDropDownValue("Модель", "5 серия", "X3")
                .selectDropDownValue("Город", "Москва")
                .setDiscountCheckbox()
                .setCheckboxInCategory("Коробка передач", "автомат")
                .setCheckboxInCategory("Привод", "полный", "задний")
                .setCheckboxInCategory("Тип кузова", "внедорожник", "седан")
                .setCheckboxInCategory("Тип топлива", "дизельное топливо", "бензин")
                .selectColor("черный")
                .setSliderInCategory("Стоимость автомобиля")
                .setSliderInCategory("Мощность двигателя")
                .setSliderInCategory("Объём двигателя")
                .clickOnFindButton();

        String carBrand = at(FilterResultPage.class).results().first().getText();
        at(FilterResultPage.class).results().first().click();

        at(CarPage.class).header().shouldHave(text(carBrand));
    }
}
