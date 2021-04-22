import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TestInfra {
    public WaiterUtils waiterUtils;

    public void VerifityIfDropDownExist(String locator) {
        try {
            WebElement webElement = waiterUtils.waitUntilWebElementAppears(locator, ConstUtils.TIME);
        } catch (Exception e) {
            System.out.println(ConstUtils.ERROR_FINDING_ELEMENT);
        }


    }

    public void InsertIntoTextField(String locator, String text) {
        try {
            WebElement webElement = waiterUtils.waitUntilWebElementAppears(locator, ConstUtils.TIME);
            webElement.sendKeys(text);
        } catch (NullPointerException e) {
            System.out.println(String.format(ConstUtils.ERROR_INSERTING_TO_TEXTFIELD, text));
        }

    }

    public void clickingOnButton(String locator) {
        try {
            WebElement webElement = waiterUtils.waitUntilWebElementClickble(locator, ConstUtils.TIME);
            webElement.click();
        } catch (NullPointerException e) {
            System.out.println(String.format(ConstUtils.ERROR_BUTTON_IS_NOT_CLICKBLE));
        }

    }

    public void choosingFromDropDown(String locatorDD, String toChoose, String locatorDDO) {
        WebElement dropDown = waiterUtils.waitUntilWebElementClickble(locatorDD, ConstUtils.TIME);
        dropDown.click();
        List<WebElement> dropDownOptions = dropDown.findElements(By.cssSelector(locatorDDO));

        for (WebElement webElement : dropDownOptions) {
            WaiterUtils.waitUntilWebElementCVsible(webElement, 10);
            if (webElement.getText().equals(toChoose)) {
                webElement.click();
                break;
            }
        }
    }

    public void checkIfAllResultsAreSorted(String asc, String locator) {
        List<WebElement> texts = waiterUtils.waitUntilAllWebElementVisible(locator, ConstUtils.TIME);
        if (asc.equals(ConstUtils.ASC)){
            if (checkIfResultsOfTestAreSortedFromAToZ(texts)) {
                System.out.println(String.format("%s-%s", ConstUtils.LIST_ARE_NOT_SORTED_AS_IT_SHOULD, asc));
            }
        }else{
            if (checkIfResultsOfTestAreSortedFromZToA(texts)) {
                System.out.println(String.format("%s-%s", ConstUtils.LIST_ARE_NOT_SORTED_AS_IT_SHOULD, asc));
            }
        }

    }

    private boolean checkIfResultsOfTestAreSortedFromAToZ(List<WebElement> texts) {
        boolean notOkay = false;
        for (int i = 1; i < texts.size(); i++) {
            if (texts.get(i - 1).getText().compareTo(texts.get(i).getText()) > 0) {
                notOkay = true;
            }
        }
        return notOkay;
    }

    private boolean checkIfResultsOfTestAreSortedFromZToA(List<WebElement> texts) {
        boolean notOkay = false;
        for (int i = 1; i < texts.size(); i++) {
            if (texts.get(i - 1).getText().compareTo(texts.get(i).getText()) < 0) {
                notOkay = true;
            }
        }
        return notOkay;
    }


}
