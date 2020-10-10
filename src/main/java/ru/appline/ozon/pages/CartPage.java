package ru.appline.ozon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.appline.ozon.entuty.entityList.ProductList;

/**
 * Карзина
 */
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CartPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(),'избранное')]/../../a/span")
    List<WebElement> productList;

    @FindBy(xpath = "//span[contains(text(),'•')]")
    WebElement elementForCartCheck;

    @FindBy(xpath = "//span[contains(text(),'Удалить выбранные')]")
    WebElement delete;

    @FindBy(xpath = "//div[contains(text(),'Удалить')]")
    WebElement deleteButton;

    @FindBy(xpath = "//h1[contains(text(), 'Корзина пуста')]")
    WebElement header;

    /**
     * проверка карщины на соответствие
     */
    public void checkProduct() {
        wait.until(new ExpectedCondition<Object>() {

            @Override
            public Object apply(WebDriver driver) {
                return productList.size() == ProductList.getProductList().size();
            }
        });


        for (WebElement webElement : productList) {
            if (!ProductList.getProductNameList().contains(webElement.getText())) {
                fail("Набор корзины изменился");
            }
        }
    }

    /**
     * проверка бокса корзина
     *
     * @param str - параметр для сравнения
     */
    public void check(String str) {
        assertEquals("Проверка заполнения раздела 'Ваша корзина'",
                elementForCartCheck.getText().split("•")[0].trim(),
                str);
    }

    /**
     * проверка бокса корзина
     */
    public void check() {
        String str;
        if (ProductList.getProductList().size() == 1) str = 1 + " товар";
        else if (ProductList.getProductList().size() == 2 ||
                ProductList.getProductList().size() == 4) str = ProductList.getProductList().size() + " товара";
        else str = ProductList.getProductList().size() + " товаров";
        assertEquals("Проверка заполнения раздела 'Ваша корзина'",
                elementForCartCheck.getText().split("•")[0].trim(),
                str);
    }

    /**
     * Очистка корзины
     */
    public void delete() {
        delete.click();
        waitToBeClickable(deleteButton);
        deleteButton.click();
    }

    /**
     * проверка после удаления
     */
    public void checkCart() {
        assertEquals("Проверка корзины после удаления",
                header.getText(), "Корзина пуста");
    }


}
