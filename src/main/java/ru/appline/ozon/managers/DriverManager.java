package ru.appline.ozon.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.appline.ozon.entuty.entityList.ProductList;

/**
 * Менеджер драйвера
 */
public class DriverManager {

    private static WebDriver driver;

    private DriverManager(){

    }

    public static WebDriver getDriver(){
        if (driver == null){
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver/chromedriver.exe");
            driver = new ChromeDriver();
        }
        return driver;
    }

    /**
     * Обнуление фреймворка
     */
    public static void quitDriver(){
        driver.quit();
        driver = null;
        PageManager.getPageManager().quit();
        ProductList.getProductList().clear();
    }
}
