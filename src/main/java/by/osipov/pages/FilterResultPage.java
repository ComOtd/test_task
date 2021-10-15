package by.osipov.pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$x;

public class FilterResultPage extends BasePage {
    /**
     * Получение результатов фильтрации
     */
    public ElementsCollection results(){
        return $$x("//a[@class='text-body']/div[@class='font-weight-bold']");
    }
}
