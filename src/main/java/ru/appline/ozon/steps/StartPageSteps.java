package ru.appline.ozon.steps;

import io.cucumber.java.ru.Когда;

/**
 * Степы с начальной страницой
 */
public class StartPageSteps extends BaseSteps{

    @Когда("^Ввод ключевого слова (.+)$")
    public void insertSearch(String str) {
        app.getStartPage().insertSearchPanel(str);
    }

    @Когда("^Клик по кнопке поиска$")
    public void clickSearch() {
        app.getStartPage().clickButton();
    }
}
