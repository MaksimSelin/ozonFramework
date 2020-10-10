package ru.appline.ozon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.appline.ozon.entuty.Product;
import ru.appline.ozon.entuty.entityList.ProductList;

import java.util.List;

/**
 * результаты поиска
 */
public class ResultPage extends BasePage {

    private int intForWait;

    private String strForWait;

    @FindBy(xpath = "//a[contains(text(), 'Смартфоны')]")
    private WebElement smartphones;

    @FindBy(xpath = "//div[contains(text(), 'По запросу')]//a")
    private WebElement category;

    @FindBy(xpath = "//div[contains(text(), 'Цена')]/..//input[@qa-id = 'range-to']")
    private WebElement price;

    @FindBy(xpath = "//div[@data-widget='searchResultsFiltersActive']/div/div")
    private List<WebElement> filterPanel;

    @FindBy(xpath = "//span[contains(text(), 'Высокий рейтинг')]")
    private WebElement highRating;

    @FindBy(xpath = "//div[contains(text(), 'Беспроводные интерфейсы')]/..")
    private WebElement wirelessInterface;

    @FindBy(xpath = "//span[contains(text(), 'Корзина')]/..//span[contains(@class, 'f-caption--bold')]")
    private WebElement elementForCheckCart;

    @FindBy(xpath = "//div[contains(@style, 'span')]")
    private List<WebElement> resultList;

    @FindBy(xpath = "//div[contains(text(),'Бренды')]/..")
    private WebElement brands;

    /**
     * выбор категории смартфоны
     */
    public void clickSmartphones() {
        strForWait = category.getText();
        smartphones.click();

        wait.until(new ExpectedCondition<Object>() {

            @Override
            public Object apply(WebDriver driver) {
                return !strForWait.equals(category.getText());
            }
        });
    }

    /**
     * установка цены
     *
     * @param str - значение
     */
    public void insertPrice(String str) {
        intForWait = filterPanel.size();
        scrollToElement(price);
        price.sendKeys(Keys.CONTROL, "a");
        price.sendKeys(str, Keys.ENTER);
        waitPageFilter();
    }

    /**
     * выбор высокого рейтинга
     */
    public void clickHighRating() {
        intForWait = filterPanel.size();
        scrollToElement(highRating);
        waitToBeClickable(highRating);
        highRating.click();
        waitPageFilter();

    }

    /**
     * выбор беспроводных интерфейсов
     *
     * @param param - параметр
     */
    public void clickWireless(String param) {
        intForWait = filterPanel.size();
        scrollToElement(wirelessInterface);
        waitToBeClickable(wirelessInterface.findElement(By.xpath(".//span[contains(text(), 'NFC')]")));
        wirelessInterface.findElement(By.xpath(".//span[contains(text(), '" + param + "')]")).click();
        waitPageFilter();
    }

    /**
     * добавление в корзину
     *
     * @param param - количество товаров
     * @param str   - четность
     */
    public void addToCart(int param, String str) {
        int k;
        if (str.equals("четных")) k = 0;
        else k = 1;
        if (resultList.size() < param * 2) param = resultList.size();
        else param = param * 2;
        add(param, k);
    }

    /**
     * добавление в корзину
     *
     * @param str - четность
     */
    public void addToCart(String str) {
        int k;
        if (str.equals("четные")) k = 0;
        else k = 1;
        add(resultList.size(), k);
    }

    /**
     * переход в корзину
     */
    public void clickOnCart() {
        scrollToElement(elementForCheckCart);
        waitToBeClickable(elementForCheckCart);
        elementForCheckCart.click();
    }

    /**
     * установка брендов
     *
     * @param list - лист брендов
     */
    public void insertBrands(List<String> list) {
        brands.click();
        brands.findElement(By.xpath(".//span[contains(text(),'Посмотреть все')]")).click();
        for (String str : list) {
            intForWait = filterPanel.size();
            waitToBeClickable(brands.findElement(By.xpath(".//div[contains(text(),'Бренды')]/..//p[contains(text(), 'Найти')]/../input")));
            brands.findElement(By.xpath(".//div[contains(text(),'Бренды')]/..//p[contains(text(), 'Найти')]/../input"))
                    .sendKeys(str);
            waitToBeClickable(brands.findElement(By.xpath(".//span[text()='" + str + "']")));
            brands.findElement(By.xpath(".//span[text()='" + str + "']")).click();
            waitPageFilter();

        }

    }

    /**
     * внутренний параметр для добавления
     * @param param - количество элементов
     * @param k - определитель четности
     */
    private void add(int param, int k) {
        for (int i = 0; i < param; i++) {
            if ((i + k) % 2 != 0) {
                strForWait = elementForCheckCart.getText();
                scrollToElement(resultList.get(i));
                ProductList.getProductList().add(new Product(resultList.get(i)
                        .findElement(By.xpath(".//div[contains(@style, '50')]//a[contains(@class, 'tile-hover-target')]"))
                        .getText(),
                        resultList.get(i).findElement(By.xpath(".//div[contains(@style, '25')]//span[contains(text(),'₽')]"))
                                .getText()));
                resultList.get(i).findElement(By.xpath(".//div[contains(text(), 'В корзину')]")).click();
                waitCart();
            }
        }
    }

    /**
     * внутренний класс проверки добавления
     */
    private void waitCart() {
        wait.until(new ExpectedCondition<Object>() {

            @Override
            public Object apply(WebDriver driver) {
                return !strForWait.equals(elementForCheckCart.getText());
            }
        });
    }


    /**
     * внутренний класс проверки фильтра
     */
    private void waitPageFilter() {
        wait.until(new ExpectedCondition<Object>() {

            @Override
            public Object apply(WebDriver driver) {
                return intForWait != filterPanel.size();
            }
        });
    }


}
