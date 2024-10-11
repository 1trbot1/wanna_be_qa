package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import utilities.CommonOps;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Verifications extends CommonOps {

    @Step("Verify x_Axis and y_Axis (SoftAssertion)")
    public static void verifyX_axisY_Axis(int x_axisOfElem, int expectedX_Axis, int y_axisOfElem, int expectedY_Axis) {
        softAssertX_axisY_Axis.assertEquals(x_axisOfElem, expectedX_Axis);
        softAssertX_axisY_Axis.assertEquals(y_axisOfElem, expectedY_Axis);
        softAssertX_axisY_Axis.assertAll();
    }

    @Step("Verify text is as expected")
    public static void verifyTextIsAsExpected(String actualText, String expectedText) {
        assertEquals(actualText, expectedText);
    }

    @Step("Verify list size is as expected")
    public static void verifyListSizeIsAsExpected(int actualSize, int expectedSize) {
        assertEquals(actualSize, expectedSize);
    }

    @Step("Verify y_Axis is as expected")
    public static void verifyY_axisIsAsExpected(int y_axisOfElem, int y_axis_expected) {
        assertEquals(y_axisOfElem, y_axis_expected);
    }

    @Step("Verify expected text includes in actual text")
    public static void verifyExpectedTextIncludesInActualText(String actualText, String expectedText) {
        assertTrue(actualText.contains(expectedText));
    }

    @Step("Verify all 'Browse trailers' tab names are as expected (SoftAssertion)")
    public static void verifyAll_BrowseTrailers_tabNamesAreAsExpected(List<String> actualNames, String expectedNames) {
        List<String> expectedNamesList = new ArrayList<>();
        String[] expectedNamesArr = expectedNames.toString().split(",");
        for (String name:expectedNamesArr) {
            expectedNamesList.add(name);
        }

        softAssert.assertEquals(actualNames, expectedNamesList);
        softAssert.assertAll();
    }

    @Step("Verify element is displayed")
    public static void verifyElementIsDisplayed(WebElement element) {
        boolean displayed = false;
        displayed = element.isDisplayed();
        assertEquals(displayed, true);
    }

}
