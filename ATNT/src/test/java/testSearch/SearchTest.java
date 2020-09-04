package testSearch;

import common.WebAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reporting.TestLogger;
import searchItem.Search;

public class SearchTest extends WebAPI {
    Search search;

    @BeforeMethod
    public void getInit() {
        search = PageFactory.initElements(driver, Search.class);
    }

//    @Test
//    public void testSearch() throws InterruptedException {
//        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
//        }.getClass().getEnclosingMethod().getName()));
//        search.searchItem();
//        search.validateSearchItem();
//    }
//    @Test
//    public void testSearchBoxCheckUsingGetItemValue() throws InterruptedException {
//        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
//        }.getClass().getEnclosingMethod().getName()));
//        search.searchBoxCheckUsingGetItemValue();
//    }

//    @Test
//    public void testSearchItemsFromDBList() throws Exception {
//        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
//        }.getClass().getEnclosingMethod().getName()));
//        search.searchItemsFromDBList();
//    }

//    @Test
//    public void testSearchItemsFromExcel() throws Exception {
//        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
//        }.getClass().getEnclosingMethod().getName()));
//        search.SearchItemsFromExcel();
//    }


    @Test
    public void testNavigateToSignInPage() throws Exception {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        search.navigateToSignInPage();
    }
}
