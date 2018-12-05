package spares;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpare extends ParentTest {
    String spareName = "dominaSpare";
    @Test
    public void addNewSpare(){
     loginPage.validLoginInToApp();
     homePage.checkUrl();
     homePage.clickOnMenuDictionary();
     homePage.clickOnSubmenuSpare();
     sparePage.checkUrl();
//     sparePage.checkAndDeleteSpare(spareName);
     sparePage.deletingSpareUntilPresent(spareName);
     sparePage.clickOnAddButton();
     editSparePage.enterSpareNameInToInput(spareName);
//     editSparePage.selectSpareTypeInDD("Механика1");
     editSparePage.dropDownSelect();
     editSparePage.clickButtonCreate();

     checkExpectedResult("Spare was not added", sparePage.isSpareinList(spareName));
    }

    @After
    public void spareDeleting(){
        sparePage.deletingSpareUntilPresent(spareName);
    }
}
