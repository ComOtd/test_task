package by.osipov.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CarPage extends BasePage{
    /**
     * Получение заголовка страницы
     */
    public SelenideElement header(){
        return $x("//h1");
    }
}
