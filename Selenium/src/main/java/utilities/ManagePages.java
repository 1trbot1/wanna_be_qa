package utilities;

import org.openqa.selenium.support.PageFactory;
import pageObjects.imdb.*;

public class ManagePages extends Base {

    public static void initIMDb() {
        imdb_mainPage = PageFactory.initElements(driver, MainPage.class);
        imdb_searchResultsPage = PageFactory.initElements(driver, SearchResultsPage.class);
        imdb_browseTrailersPage = PageFactory.initElements(driver, BrowseTrailersPage.class);
        imdb_mainMenuPage = PageFactory.initElements(driver, MainMenuPage.class);
        imdb_topMenuPage = PageFactory.initElements(driver, TopMenuPage.class);
        imdb_footerPage = PageFactory.initElements(driver, FooterPage.class);
    }

}
