package sanity;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import utilities.ExecutionData;
import workFlows.WebFlows;

@Listeners(utilities.ListenersAuto.class)
public class IMDb extends CommonOps {

    @ExecutionData(name = ExecutionData.Testers.DAKOTA, category = ExecutionData.Category.SANITY_DESIGN, company = "Home")
    @Test(groups = "sanity", description = "Test 01: Verify x_Axis and y_Axis of 'IMDb' label")
    @Description("Verify Same x_Axis and y_Axis of Element 'IMDb' label MAXSIZE laptop window (using SoftAssert)")
    public void test01_verifyX_axisY_AxisIMDbLabel() {
        Verifications.verifyX_axisY_Axis(UIActions.getX_AxisOfElement(imdb_topMenuPage.lbl_mainLabel), Integer.parseInt(getData("x_AxisOfElementIMDb")), UIActions.getY_AxisOfElement(imdb_topMenuPage.lbl_mainLabel), Integer.parseInt(getData("y_AxisOfElementIMDb")));
    }

    @ExecutionData(name = ExecutionData.Testers.DAKOTA, category = ExecutionData.Category.SANITY_DESIGN, company = "Home")
    @Test(groups = "sanity", description = "Test 02: Verify y_Axis of 'IMDb' label not max resolution", dataProvider = "data-provider-resolutions", dataProviderClass = utilities.ManageDDT.class)
    @Description("Verify y_Axis of Element 'IMDb' label OTHER_SIZE window (using DDT)")
    public void test02_verifyY_AxisSearch(String width, String height) {
        UIActions.changeWindowSize(Integer.parseInt(width), Integer.parseInt(height));
        Verifications.verifyY_axisIsAsExpected(UIActions.getY_AxisOfElement(imdb_topMenuPage.lbl_mainLabel), Integer.parseInt(getData("y_AxisOfElementIMDb")));
    }

    @ExecutionData(name = ExecutionData.Testers.DAKOTA, category = ExecutionData.Category.SANITY_AMOUNT, company = "Home")
    @Test(groups = "sanity", description = "Test 03: Verify amount of 'all' categories in topMenu is as expected")
    @Description("Open 'all'.\n Verify amount of 'all' categories in topMenu is as expected")
    public void test03_verifyAmountOf_all_CategoriesInTopMenuIsAsExpected() {
        UIActions.click(imdb_topMenuPage.btn_all);
        Verifications.verifyListSizeIsAsExpected(UIActions.getListSize(imdb_topMenuPage.list_categories), Integer.parseInt(getData("allCategories_topMenu_listSize")));
    }

    @ExecutionData(name = ExecutionData.Testers.DAKOTA, category = ExecutionData.Category.SANITY_CONFORMITY, company = "Home")
    @Test(groups = "sanity", description = "Test 04: Verify 'From your Watchlist' title text is as expected")
    @Description("Verify 'From your Watchlist' title text is as expected")
    public void test04_verifyFromYourWatchlistTitleTextIsAsExpected() {
        Verifications.verifyTextIsAsExpected(WebFlows.getTitleTextFrom_FromYourWatchlist_section(), getData("titleTextFrom_FromYourWatchlist_section"));
    }

    @ExecutionData(name = ExecutionData.Testers.DAKOTA, category = ExecutionData.Category.SANITY_AMOUNT, company = "Home")
    @Test(groups = "sanity", description = "Test 05: Verify amount of search results sections", dataProvider = "data-provider-textForSearch", dataProviderClass = utilities.ManageDDT.class)
    @Description("Search text.\n Verify amount of search results sections")
    public void test05_verifyAmountOfSearchResultsSections(String textForSearch) {
        WebFlows.searchOnSite(textForSearch);
        Verifications.verifyListSizeIsAsExpected(UIActions.getListSize(imdb_searchResultsPage.list_resultsSections), Integer.parseInt(getData("searchResultsSections")));
    }

    @ExecutionData(name = ExecutionData.Testers.DAKOTA, category = ExecutionData.Category.SANITY_CONFORMITY, company = "Home")
    @Test(groups = "sanity", description = "Test 06: Verify all 'Browse trailers' tab names are as expected")
    @Description("Go to 'Browse trailers'.\n Verify all 'Browse trailers' tab names are as expected (using SoftAssert)")
    public void test06_verifyAll_BrowseTrailers_tabNamesAreAsExpected() {
        WebFlows.goToBrowseTrailers();
        Verifications.verifyAll_BrowseTrailers_tabNamesAreAsExpected(WebFlows.getBrowseTrailersTabNames(imdb_browseTrailersPage.list_tabs), getData("browseTrailersTabNames"));
    }

    @ExecutionData(name = ExecutionData.Testers.DAKOTA, category = ExecutionData.Category.SANITY_CONFORMITY, company = "Home")
    @Test(groups = "sanity", description = "Test 07: Verify 'Sign in for more access' button on 'Browse Trailers' page is displayed")
    @Description("Go to 'Browse trailers'.\n Verify 'Sign in for more access' button is displayed")
    public void test07_verify_SingInForMoreAccess_buttonIsDisplayedOnBrowseTrailersPage() {
        WebFlows.goToBrowseTrailers();
        Verifications.verifyElementIsDisplayed(imdb_footerPage.btn_signInForMoreAccess);
    }

    @ExecutionData(name = ExecutionData.Testers.DAKOTA, category = ExecutionData.Category.SANITY_AMOUNT, company = "Home")
    @Test(groups = "sanity", description = "Test 08: Verify amount of Main Menu categories is as expected")
    @Description("Open 'Menu'.\n Verify amount of Main Menu categories is as expected")
    public void test08_verifyAmountOfMainMenuCategoriesIsAsExpected() {
        UIActions.click(imdb_topMenuPage.btn_menu);
        Verifications.verifyListSizeIsAsExpected(UIActions.getListSize(imdb_mainMenuPage.list_menuCategories), Integer.parseInt(getData("mainMenuCategories")));
    }

    @ExecutionData(name = ExecutionData.Testers.DAKOTA, category = ExecutionData.Category.SANITY_CONFORMITY, company = "Home")
    @Test(groups = "sanity", description = "Test 09: Verify that English is fully supported language")
    @Description("Open 'Language menu'.\n Verify that English is fully supported language")
    public void test09_verifyThatEnglishIsFullySupportedLanguage() {
        UIActions.click(imdb_topMenuPage.btn_languages);
        Verifications.verifyTextIsAsExpected(UIActions.getAriaLabelAttribute(imdb_topMenuPage.elem_fullySupportedLanguage), getData("fullySupportedLanguage"));
    }

    @ExecutionData(name = ExecutionData.Testers.DAKOTA, category = ExecutionData.Category.SANITY_AMOUNT, company = "Home")
    @Test(groups = "sanity", description = "Test 10: Verify amount of social links is as expected")
    @Description("Verify amount of social links is as expected")
    public void test10_verifyAmountOfSocialLinksIsAsExpected() {
        Verifications.verifyListSizeIsAsExpected(UIActions.getListSize(imdb_footerPage.list_socialLinks), Integer.parseInt(getData("socialLinksList")));
    }

    @ExecutionData(name = ExecutionData.Testers.DAKOTA, category = ExecutionData.Category.SANITY_CONFORMITY, company = "Home")
    @Test(groups = "sanity", description = "Test 11: Verify Present Year Included in Copyright")
    @Description("Verify Present Year Included in Copyright")
    public void test11_verifyPresentYearIncludedInCopyright() {
        Verifications.verifyExpectedTextIncludesInActualText(UIActions.getText(imdb_footerPage.lbl_copyright), UIActions.getPresentYear());
    }

}
