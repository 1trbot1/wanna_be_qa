package pageObjects.imdb;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FooterPage {

    @FindBy(xpath = "//span[text()='Sign in for more access']//ancestor::a[contains(@class,'sign-in-button')]")
    public WebElement btn_signInForMoreAccess;

    @FindBy(xpath = "//div[contains(@class,'footer__links')]//section//ul[contains(@class,'footer__linksRow')]//a")
    public List<WebElement> list_socialLinks;

    @FindBy(xpath = "//p[contains(@class, 'footer__copyright')]")
    public WebElement lbl_copyright;

}
