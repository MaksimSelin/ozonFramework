package ru.appline.ozon.managers;

import java.util.concurrent.TimeUnit;

import static ru.appline.ozon.utils.StaticField.*;

/**
 * Начальные настройки
 */
public class InitManager {
    public static void initFramework(){
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Integer.parseInt(IMPLICITLY_WAIT), TimeUnit.SECONDS);
        DriverManager.getDriver().manage().timeouts().pageLoadTimeout(Integer.parseInt(PAGE_LOAD_TIMEOUT), TimeUnit.SECONDS);
        DriverManager.getDriver().get(APP_URL);
    }

    public static void closeFramework(){
        DriverManager.quitDriver();
    }
}
