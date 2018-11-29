package spares;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpare extends ParentTest{
    String spareName = "kostenkoSpare";

    @Test
    public void addNewSpare(){
        loginPage.validLoginInToApp();
        homePage.checkUrl();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpare();
        sparePage.checkUrl();
//        sparePage.checkAndDeleteSpace (spareName);
        sparePage.deletingSpareUntilPresent (spareName);
        sparePage.clickOnAddButton ();
        editSparePage.enterSpareNameIntoImput (spareName);
        editSparePage.selectSpareTypeInDD("Механика1");
        editSparePage.clickOnButtonCreate();

        checkExpectedResult("Spare was not added", sparePage.isSpareInList(spareName));

    }
    @After
    public void spareDeleting () {
        sparePage.deletingSpareUntilPresent(spareName);
    }
}
