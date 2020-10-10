package ru.appline.ozon.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.appline.ozon.managers.DriverManager;

/**
 * супер класс
 */
public class BasePage {

    WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 10);

    public BasePage(){
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    protected void scrollToElement(WebElement webElement) {
        ((JavascriptExecutor)DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView();", webElement);

//        ((JavascriptExecutor) DriverManager.getDriver()).executeScript(
//                "window.scroll(" + (webElement.getLocation().x + 0) + ","
//                        + (webElement.getLocation().y - 100) + ");", webElement, 0, -100);
    }

    public void waitToBeClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitLoadPage(){
        wait.until(
                driver -> ((JavascriptExecutor) DriverManager.getDriver()).executeScript("return document.readyState")
                        .equals("complete"));
    }
}
