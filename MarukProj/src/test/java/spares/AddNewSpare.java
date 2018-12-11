package spares;

import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpare extends ParentTest {
    String spareName = "MarukSpare";   //створили деталь, яку будемо додавати
    @Test
    public  void addNewSpare(){
        logInPage.validLoginIntoApp();
        homePage.checkUrl();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpare();
        sparePage.checkUrl();
        //sparePage.checkAndDeleteSpare(spareName);
        sparePage.deletingSpareUntilPresent(spareName);
        sparePage.clickOnAddButton();
        editSparePage.enterSpareNameIntoInput(spareName);
        editSparePage.selectSpareTypeInDD("Механика1");   // homework
        editSparePage.clickOnButtonCreate();

        checkExpectedResult("Spare was not added",sparePage.isSpareInList(spareName));
    }

    @After
    public void spareDeleting(){
        sparePage.deletingSpareUntilPresent(spareName);

    }

}
