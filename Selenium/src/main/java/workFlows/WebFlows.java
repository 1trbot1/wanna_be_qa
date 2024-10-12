package workFlows;

import extensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CommonOps;

import java.util.ArrayList;
import java.util.List;


public class WebFlows extends CommonOps {

    @Step("Business Flow: scroll to the section")
    public static void scrollToSection(String sectionName) {
        String sectionXpath = "//h3[text()='"+sectionName+"']";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sectionXpath)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(sectionXpath)));
    }

    @Step("Business Flow: get title text from 'From your Watchlist' section")
    public static String getTitleTextFrom_FromYourWatchlist_section() {
        scrollToSection("What to watch");
        return UIActions.getText(imdb_mainPage.titleTxt_fromYourWatchlist);
    }

    @Step("Business Flow: Search on Site")
    public static void searchOnSite(String textForSearch) {
        UIActions.click(imdb_topMenuPage.input_search);
        UIActions.updateText(imdb_topMenuPage.input_search, textForSearch);
        UIActions.sendKeyBoardEnter(imdb_topMenuPage.input_search);
    }

    @Step("Business Flow: Go to 'Browse trailers'")
    public static void goToBrowseTrailers() {
        mouseHover(imdb_mainPage.link_browseTrailers);
        UIActions.click(imdb_mainPage.link_browseTrailers);
    }

    @Step("Business Flow: Mouse Hover")
    public static void mouseHover(WebElement element) {
        actions.moveToElement(element).build().perform();
    }

    @Step("Business Flow: get 'Browse trailers' tab names like list")
    public static List<String> getBrowseTrailersTabNames(List<WebElement> browseTrailersTabList) {
        List<String> namesList = new ArrayList<>();
        for (WebElement tab:browseTrailersTabList) {
            namesList.add(tab.findElement(By.xpath(".//span")).getText());
        }
        return namesList;
    }


}
