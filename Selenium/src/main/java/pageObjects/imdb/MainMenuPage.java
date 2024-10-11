package pageObjects.imdb;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainMenuPage {

    @FindBy(xpath = "//div[@class='drawer__panelContent']//div[@data-testid='nav-link-category' and @role]")
    public List<WebElement> list_menuCategories;

}
