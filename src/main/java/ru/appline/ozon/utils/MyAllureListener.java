package ru.appline.ozon.utils;

import io.cucumber.plugin.event.*;
import io.qameta.allure.Attachment;
import io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.appline.ozon.managers.DriverManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * кастомный листенер
 */
public class MyAllureListener extends AllureCucumber6Jvm {

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestStepFinished.class, new EventHandler<TestStepFinished>() {
            @Override
            public void receive(TestStepFinished event) {
                if (event.getResult().getStatus().is(Status.FAILED)) {
                    addScreenshot();
                }
            }
        });
        super.setEventPublisher(publisher);
    }

    @Attachment(value = "FailScreen", type = "image/png")
    public static byte[] addScreenshot() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "file",type = "text/plain")
    public static byte[] file() throws IOException {

        return Files.readAllBytes(Paths.get("src/main/resources/text.txt"));
    }

}
