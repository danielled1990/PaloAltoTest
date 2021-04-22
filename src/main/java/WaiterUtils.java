import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WaiterUtils {

    public static WebElement waitUntilWebElementAppears(String locator,int time){
        return new WebDriverWait(EngineStart.getWebDriver(),time)
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
    }

    public static WebElement waitUntilWebElementClickble(String locator,int time){
        return new WebDriverWait(EngineStart.getWebDriver(),time)
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(locator)));
    }

    public static void waitUntilWebElementCVsible(WebElement webElement,int time){
         new WebDriverWait(EngineStart.getWebDriver(),time)
                .until(ExpectedConditions.visibilityOf(webElement));

    }

    public static List<WebElement> waitUntilAllWebElementVisible(String locator,int time){
        return new WebDriverWait(EngineStart.getWebDriver(), time)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(locator)));
    }
}
