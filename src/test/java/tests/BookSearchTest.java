package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AmazonHomePage;

public class BookSearchTest extends BaseTest {

    @DataProvider(name = "bookData")
    public Object[][] getData() {
        return new Object[][]{
                {"motivational book", "Atomic Habits"},
                {"motivational book", "Deep Work"}
        };
    }

    @Test(dataProvider = "bookData")
    public void verifyBookInFirstPage(String searchKeyword, String bookName) {

        AmazonHomePage home = new AmazonHomePage(driver);

        home.searchBook(searchKeyword);

        boolean result = home.isBookPresent(bookName);

        if (result) {
            System.out.println("PASS: " + bookName + " found on first page");
        } else {
            System.out.println("FAIL: " + bookName + " not found on first page");
        }

        Assert.assertTrue(result);
    }
}