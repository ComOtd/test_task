package by.osipov.pages;

import static com.codeborne.selenide.Condition.*;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.By.xpath;

public class MarketplaceFilterPage extends BasePage {
    private final By slider = byClassName("el-slider__runway");
    private final By spinner = xpath("//div[@class='el-loading-spinner']");
    private final By colorDropDown = byClassName("horizontal-filter-block__selector-values");

    //Ожидает loader
    private void load() {
        $(spinner).shouldBe(visible, ofSeconds(10));
        $(spinner).shouldNotBe(visible, ofSeconds(10));
    }

    private SelenideElement dropDown(String name) {
        return $(byText(name)).parent();
    }

    private SelenideElement category(String name) {
        return $(byText(name)).parent();
    }

    /**
     * Выбирает значение из выпадающего списка
     * @param dropDownName Название выпадающего списка
     * @param args одно или несколько значений
     */
    public MarketplaceFilterPage selectDropDownValue(String dropDownName, String... args) {
        dropDown(dropDownName).click();
        for (String value : args) {
            dropDown(dropDownName).find(byText(value)).click();
            load();
        }
        return this;
    }

    /**
     * Выбирает цвет из выпадающего списка "Цвет"
     * @param args одно или несколько значений
     */
    public MarketplaceFilterPage selectColor(String... args) {
        for (String text : args) {
            category("Цвет").find(byTagName("input")).click();
            category("Цвет").find(colorDropDown)
                    .find(byText(text)).click();
            load();
        }
        return this;
    }

    /**
     * Устанавливает чекбокс "Только авто со скидкой"
     */
    public MarketplaceFilterPage setDiscountCheckbox() {
        $(byText("Только авто со скидкой")).parent().click();
        load();
        return this;
    }

    /**
     * Устанавливает чекбокс в категории
     * @param category название категории
     * @param args один или несколько чекбоксов
     */
    public MarketplaceFilterPage setCheckboxInCategory(String category, String... args) {
        for (String text : args) {
            category(category).find(byText(text)).parent().click();
            load();
        }
        return this;
    }

    /**
     * Нажимает на кнопку "Показать все предложения"
     */
    public FilterResultPage clickOnFindButton() {
        $(byText("Показать все предложения")).click();
        return page(FilterResultPage.class);
    }

    /**
     * Устанавливает минимальное значение слайдера на среднее значение
     * @param category название категории слайдера
     */
    public MarketplaceFilterPage setSliderInCategory(String category){
        category(category).scrollTo().find(slider).click();
        load();
        return this;
    }

}
