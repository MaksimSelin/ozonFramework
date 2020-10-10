package ru.appline.ozon.steps;

import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Allure;
import ru.appline.ozon.entuty.entityList.ProductList;
import ru.appline.ozon.utils.Writer;

import java.io.IOException;

import static ru.appline.ozon.utils.MyAllureListener.file;

/**
 * степы с карзиной
 */
public class CartPageSteps extends BaseSteps {

    @Тогда("^Проверка продутов в корзине$")
    public void checkProductsOnCart() {

        Writer.write();

        try {
            Allure.getLifecycle().addAttachment("file","text/plain",null,file());
        } catch (IOException e) {
            e.printStackTrace();
        }

        app.getCartPage().checkProduct();

        Writer.delete();
    }

    @Тогда("^Проверка надписи (\\d+) (товаров|товара|товар)$")
    public void checkCountProduct(int param1, String param2) {
        app.getCartPage().check(param1 + " " + param2);
    }

    @Тогда("^Удалить выбранные элементы$")
    public void delete() {
        app.getCartPage().delete();
    }

    @Тогда("^Проверка корзины на отсутствие продуктов$")
    public void checkCart() {
        app.getCartPage().checkCart();
    }

    @Тогда("^Проверка 'Ваша корзина'$")
    public void checkYourCart() {
        app.getCartPage().check();
    }

}
