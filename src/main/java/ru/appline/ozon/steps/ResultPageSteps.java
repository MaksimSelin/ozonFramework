package ru.appline.ozon.steps;

import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

import java.util.List;

/**
 * степы с результатами
 */
public class ResultPageSteps extends BaseSteps{

    @Когда("^Выбрать категорию смартфоны$")
    public void insertCategory() {
        app.getResultPage().clickSmartphones();
    }

    @Когда("^Ограничение цены (\\d+)$")
    public void insertPrice(String str) {
        app.getResultPage().insertPrice(str);
    }

    @Когда("^Отметить переключатель высокий рейтинг$")
    public void clickHighRating() {
        app.getResultPage().clickHighRating();
    }

    @Когда("^Отметить чекбокс (NFC|Bluetooth|Wi-Fi)$")
    public void clickWirelessInterface(String param) {
        app.getResultPage().clickWireless(param);
    }

    @Тогда("^Добавить в корзину (\\d+) (четных|нечетных) продуктов$")
    public void addToCart(int param, String str) {
        app.getResultPage().addToCart(param, str);
    }

    @Тогда("^Переход в корзину$")
    public void clickOnCart() {
        app.getResultPage().clickOnCart();
    }

    @Когда("^Выбор брендов$")
    public void insertBrand(List<String> list) {
        app.getResultPage().insertBrands(list);
    }

    @Тогда("^Добавить все (четные|нечетные) товары$")
    public void addToCart(String str){
        app.getResultPage().addToCart(str);
    }
}
