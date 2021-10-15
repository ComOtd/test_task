package by.osipov.pages;

import static com.codeborne.selenide.Selenide.page;

public class BasePage {
    /**
     * Получение страницы по классу
     * Для читаемости
     */
    public static <T extends BasePage> T at(Class<T> page) {
        return page(page);
    }
}
