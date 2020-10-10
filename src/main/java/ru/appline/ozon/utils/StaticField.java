package ru.appline.ozon.utils;

import ru.appline.ozon.managers.PropManager;

public class StaticField {
    public static final String APP_URL = PropManager.getPropManager().getProperty("app.url");
    public static final String PATH_CHROME_DRIVER = PropManager.getPropManager().getProperty("path.chrome.driver");
    public static final String IMPLICITLY_WAIT = PropManager.getPropManager().getProperty("implicitly.Wait");
    public static final String PAGE_LOAD_TIMEOUT = PropManager.getPropManager().getProperty("page.Load.Timeout");

}
