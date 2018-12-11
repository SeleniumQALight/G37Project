package spares;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpare extends ParentTest {

    String spareName = "smirnovSpare";


    @Test
    public void addNewSpare() {
        loginPage.validLoginInToApp();
        homePage.checkUrl();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpare();
        sparePage.checkUrl();
//        sparePage.chackAndDeleteSpare(spareName);
        sparePage.deletingSpareUntilPresent(spareName);
        sparePage.clickOnAddButton();
        editSparePage.enterSpareNameInToInput(spareName);
        editSparePage.selectSpareTypeInDD("Механика1");
        editSparePage.clickButtonCreate();
//        Assert.assertTrue("Spare was not added",sparePage.isSpareInList(spareName));
//        checkExpectedResult("Spare was not added",true,sparePage.isSpareInList(spareName));
        checkExpectedResult("Spare was not added",sparePage.isSpareInList(spareName));

    }
    @After
    public void spateDeleting() {
        sparePage.deletingSpareUntilPresent(spareName);
    }

}


