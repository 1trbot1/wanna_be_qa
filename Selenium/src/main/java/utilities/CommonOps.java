package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class CommonOps extends Base {

    public static String getData(String nodeName) {
        DocumentBuilder dBuilder;
        Document doc = null;
        File fXmlFile = new File("./Configuration/DataConfigIMDb.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);        }
        catch(Exception e) {
            System.out.println("Exception in reading XML file: " + e);        }
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }

    public void initBrowser(String browserType) {
        if (browserType.equalsIgnoreCase("chrome"))
            driver = initChromeDriver();
        else if (browserType.equalsIgnoreCase("edge"))
            driver = initEdgeDriver();
        else if (browserType.equalsIgnoreCase("firefox"))
            driver = initFirefoxDriver();
        else
            throw new RuntimeException("Invalid browser type");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        ManagePages.initIMDb();
        wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        actions = new Actions(driver);
    }

    public static WebDriver initChromeDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }
    public static WebDriver initEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        return driver;
    }
    public static WebDriver initFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    @BeforeClass(groups = "sanity")
    public void startSession() {
        if (getData("PlatformNameOfTest").equalsIgnoreCase("web"))
            initBrowser(getData("BrowserType"));
        else
            throw new RuntimeException("Invalid platform");

        softAssert = new SoftAssert();
        softAssertX_axisY_Axis = new SoftAssert();
    }

    @AfterClass(groups = "sanity")
    public void closeSession() {
        driver.close();
        driver.quit();
    }

    @BeforeMethod(groups = "sanity")
    public void beforeMethod(Method method) {
        driver.manage().window().maximize();
        driver.get(getData("URL"));
        wait.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));

    }

}