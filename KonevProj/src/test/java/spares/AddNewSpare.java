package spares;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpare extends ParentTest {

    String spareName = "konevSpare";


    @Test
    public void addNewSpare() {
        loginPage.validLoginInToApp();
        homePage.checkUrl();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpare();
        sparePage.checkUrl();
//        for (int i = 0; i <3; i++) {
//            sparePage.clickOnAddButton();
//            editSparePage.enterSpareNameInToInput(spareName);
//            editSparePage.manualSelectSpareTypeInDD("Механика1");
//            editSparePage.clickButtonCreate();
//        }
      sparePage.checkAndDeleteSpare(spareName);
       // sparePage.deletingSpareUntilPresent(spareName);
        sparePage.clickOnAddButton();
        editSparePage.enterSpareNameInToInput(spareName);
        //editSparePage.selectSpareTypeInDD("Механика1");
        editSparePage.manualSelectSpareTypeInDD("Механика1");
        editSparePage.clickButtonCreate();

        checkExpectedResult("Spare wasn't added", sparePage.isSpareInList(spareName));
        // Assert.assertTrue("Spare wasn't added", sparePage.isSpareInList(spareName));
    }

    @After
    public void spareDelete() {
       //sparePage.deletingSpareUntilPresent(spareName);
       sparePage.checkAndDeleteSpare(spareName);
    }

}
