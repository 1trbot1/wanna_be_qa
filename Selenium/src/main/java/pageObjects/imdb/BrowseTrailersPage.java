package pageObjects.imdb;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BrowseTrailersPage {

    @FindBy(xpath = "//li[@role='tab']")
    public List<WebElement> list_tabs;

}
