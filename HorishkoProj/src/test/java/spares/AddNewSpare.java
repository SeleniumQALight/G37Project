package spares;

import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpare extends ParentTest {
    String spareName = "KhorishkoSpare";
    @Test
    public void addNewSpare(){
        loginPage.validLoginInToApp();
        homePage.checkUrl();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpare();
        sparePage.checkUrl();
        sparePage.checkAndDeliteSpare(spareName);
        sparePage.clickOnAddButton();
        editSparePage.enterSpareNameInToInpuy(spareName);
        editSparePage.selectSpareTypeInDD("Механика1");
        editSparePage.selectSpareTypeInDDByValue("40");
        editSparePage.clickButtonCreate();

    }
}
