package spares;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpare extends ParentTest {
    String spareName = "FedorenkoSpare";

    @Test
    public void addNewSpare (){
        loginPage.validLoginInToApp();
        homePage.checkUrl();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpares();
        sparePage.checkUrl();
        sparePage.deletingSpareUntilPresent(spareName);
//        sparePage.checkAndDeleteSpare (spareName);
        sparePage.clickOnAddButton();
        editSparePage.enterSpareNameIntoInput(spareName);
        editSparePage.ownSelectSpareTypeInDDByValue ("60");
//        editSparePage.ownSelectSpareTypeInDDByText("Механика1");
//        editSparePage.selectSpareTypeInDD("Механика1");
        editSparePage.clickButtonCreate();

        checkExpectedResult("Spare was not added", sparePage.isSpareInList(spareName));
    }
    @After
    public void spareDeleting(){
        sparePage.deletingSpareUntilPresent(spareName);
    }
}
