package fetraining.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.ConfigLoader;

public class BaseElements {
    private String propertyFilePath = "src/test/resources/properties/FeTraining.properties";
    private String link;
    protected WebDriver driver;
    protected ConfigLoader configLoader;

    BaseElements(WebDriver driver) {
        this.driver =  driver;
        configLoader = new ConfigLoader(propertyFilePath);
    }

    public String GetLink(){
        return link;
    }
    protected By GetElementByCSSSlecetor(String selector){ return By.cssSelector(selector); }
    protected void SetLink(String link) {
        this.link = link;
    }
}
