package spares;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpare extends ParentTest {
    String spareName = "danishSpare";
    @Test
    public void addNewSpare(){
        loginPage.validLoginInToApp();
        homePage.checkUrl();
        homePage.clickOnMenuDictionaty();
        homePage.clickOnSubMenuSpare();
        sparePage.checkUrl();
        //sparePage.checkAndDeleteSpare(spareName);
        sparePage.deletingSpareUntilPresent (spareName);
        sparePage.clickOnAddButton();
        editSparePage.enterSpareNameInToInput(spareName);
        editSparePage.selectSpareTypeInDD("Механика1");
        editSparePage.manualSelectSpareTypeInDD("Механика1");
        editSparePage.clickButtonCreate();

        checkExpectedResult("Spare was't added ",true, sparePage.isSpareInList(spareName));




    }
    @After
    public void spareDeleting(){
        sparePage.deletingSpareUntilPresent(spareName);
    }


}
