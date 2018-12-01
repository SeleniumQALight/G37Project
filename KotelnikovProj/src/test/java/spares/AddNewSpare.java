package spares;

import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpare extends ParentTest {
    String spareName = "kotelnikovSpare";
    @Test
    public void addNewSpare(){
        loginPage.validLoginIntoApp();
        homePage.checkUrl();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpare();
        sparePage.checkUrl();
        sparePage.deletingSpareUntilPresent(spareName);
        sparePage.clickOnAddButton();
        editSparePage.enterSpareNameIntoInput(spareName);
        editSparePage.selectSpareTypeInDropDown("Механика1");
        editSparePage.clickOnButtonCreate();

        checkExpectedesult("Spare wasn't added ", sparePage.isSpareInList(spareName));
    }

    @After
    public void spareDeleting(){
        sparePage.deletingSpareUntilPresent(spareName);
    }
}
