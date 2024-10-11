package pageObjects.imdb;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage {

    @FindBy(xpath = "//section[contains(@data-testid,'find-results-section')]")
    public List<WebElement> list_resultsSections;

}
