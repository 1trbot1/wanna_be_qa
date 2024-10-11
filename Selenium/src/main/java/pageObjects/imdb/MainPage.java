package pageObjects.imdb;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage {
    @FindBy(xpath = "//h3[text()='From your Watchlist']//ancestor::div[contains(@class,'ipc-page-grid--bias-left')]//div[@class='from-your-watchlist']//div[contains(@class,'title') and contains(@class,'from-your-watchlist')]")
    public WebElement titleTxt_fromYourWatchlist;

    @FindBy(xpath = "//a[text()='Browse trailers']")
    public WebElement link_browseTrailers;

}
