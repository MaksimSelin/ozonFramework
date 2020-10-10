package ru.appline.ozon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;

/**
 * начальная страница
 */
public class StartPage extends BasePage {

    @FindBy(xpath = "//div[@data-widget = 'searchBarDesktop']")
    private WebElement searchPanel;

    String forWait;

    /**
     * заполнения поля поиска
     *
     * @param str - параметр поиска
     */
    public void insertSearchPanel(String str) {
        forWait = searchPanel.findElement(By.xpath("//input[@placeholder = 'Искать на Ozon']")).getAttribute("value");
        searchPanel.findElement(By.xpath("//input[@placeholder = 'Искать на Ozon']")).sendKeys(str);

        wait.until(new ExpectedCondition<Object>() {

            @Override
            public Object apply(WebDriver driver) {
                return !forWait.equals(searchPanel.findElement(By.xpath("//input[@placeholder = 'Искать на Ozon']"))
                        .getAttribute("value"));
            }
        });
    }

    /**
     * нажатие на кнопку найти
     */
    public void clickButton() {
        searchPanel.findElement(By.xpath(".//button")).click();
    }
}
