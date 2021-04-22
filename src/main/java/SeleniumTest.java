

public class SeleniumTest {

    public static void main(String[] args) {
        System.out.println("“Test sort alphabecally ascending");
        TestInfra testInfra = new TestInfra();
        EngineStart.ChromeBrowserLaunch();
        testInfra.VerifityIfDropDownExist(".btn.btn-link.dropdown-toggle");
        testInfra.InsertIntoTextField("#search input","ipod");
        testInfra.clickingOnButton("#search button");
        testInfra.clickingOnButton("#list-view");
        testInfra.choosingFromDropDown("#input-sort","Name (A - Z)","option");
//        testInfra.choosingFromDropDown("#input-sort","Name (Z - A)","option");
        testInfra.checkIfAllResultsAreSorted("asc","h4 a");
//        testInfra.checkIfAllResultsAreSorted("dsc","h4 a");
        EngineStart.CloseBrowser();
    }
}
