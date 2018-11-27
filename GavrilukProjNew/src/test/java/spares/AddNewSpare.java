package spares;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import pages.SparePage;
import parenTest.ParentTest;

public class AddNewSpare extends ParentTest{
    String spareName = "gavryliukSpare";
    @Test
    public void addNewSpare(){
        loginPage.validLoginInToApp();
        homePage.checkUrl();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpare();
        sparePage.checkUrl();
     //   sparePage.checkAndDeleteSpare(spareName);
        sparePage.deletingSpareUntilPresent(spareName);
        sparePage.clickOnAddButton();
        editSparePage.enterSpareNameInToImput(spareName);
        editSparePage.selectSpareTypeInDD("Механика1");
        editSparePage.clickButtonCreate();

        checkExpectedResult("Spare was not added", sparePage.isSpareInList(spareName));

    }
    @After
    public void spareDeleting(){
        sparePage.deletingSpareUntilPresent(spareName);
    }
}
