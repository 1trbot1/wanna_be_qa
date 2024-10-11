package pageObjects.imdb;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TopMenuPage {

    @FindBy(xpath = "//label[@data-testid='category-selector-button']")
    public WebElement btn_all;

    @FindBy(xpath = "//ul[@role='menu' and contains(@class, 'searchCatSelector')]/li")
    public List<WebElement> list_categories;

    @FindBy(xpath = "//a[@id='home_img_holder']")
    public WebElement lbl_mainLabel;

    @FindBy(xpath = "//input[@placeholder=\"Search IMDb\"]")
    public WebElement input_search;

    @FindBy(xpath = "//label[@id='imdbHeader-navDrawerOpen']")
    public WebElement btn_menu;

    @FindBy(xpath = "//label[@for='nav-language-selector']")
    public WebElement btn_languages;

    @FindBy(xpath = "//span[@id='nav-language-selector-contents']//ul[contains(@class,'fully-supported-languages')]//li[@role='menuitem' and @id]")
    public WebElement elem_fullySupportedLanguage;
}
