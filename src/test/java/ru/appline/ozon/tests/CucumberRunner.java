package ru.appline.ozon.tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"ru.appline.ozon.steps"},
        features = {"src/test/resources"},
        tags = "@positive",
        plugin = {"pretty", "ru.appline.ozon.utils.MyAllureListener"}
)
public class CucumberRunner {

}

