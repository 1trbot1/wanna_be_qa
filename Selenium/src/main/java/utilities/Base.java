package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import pageObjects.imdb.*;


public class Base {

    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static Actions actions;
    protected static SoftAssert softAssert;
    protected static SoftAssert softAssertX_axisY_Axis;


//--------Page Objects--------
    protected static MainPage imdb_mainPage;
    protected static TopMenuPage imdb_topMenuPage;
    protected static SearchResultsPage imdb_searchResultsPage;
    protected static BrowseTrailersPage imdb_browseTrailersPage;
    protected static MainMenuPage imdb_mainMenuPage;
    protected static FooterPage imdb_footerPage;

}
