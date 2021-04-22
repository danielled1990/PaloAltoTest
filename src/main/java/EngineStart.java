import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public  class EngineStart {
    private static WebDriver driver;

    public static void ChromeBrowserLaunch() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(ConstUtils.URL);
        driver.manage().window().maximize();
    }

    public  static WebDriver getWebDriver(){
        return driver;
    }

    public static void CloseBrowser() {
        driver.quit();
    }
}
