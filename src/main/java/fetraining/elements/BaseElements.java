package fetraining.elements;

import org.openqa.selenium.WebDriver;

public class BaseElements {
    private String link;
    protected WebDriver driver;

    BaseElements(WebDriver driver)
    {
        this.driver =  driver;
    }

    public String GetLink(){
        return link;
    }

    protected void SetLink(String link) {
        this.link = link;
    }
}
