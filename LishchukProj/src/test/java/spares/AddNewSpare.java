package spares;

import org.junit.Test;
import pages.HomePage;
import pages.LoginPage;
import parentTest.ParentTest;

public class AddNewSpare extends ParentTest {
    String spareName = "lishchukSpare";
    @Test
    public void addNewSpare() {
        loginPage.validLoginInToApp();
        homePage.checkUrl();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpare();
        sparePage.checkUrl();
        sparePage.checkAndDeleteSpare(spareName);
        sparePage.clickOnAddButton();
        editSparePage.enterSpareNameInToInput(spareName);
        editSparePage.selectSpareTypeInDD("Механика1");
        editSparePage.clickButtonCreate();
    }
}