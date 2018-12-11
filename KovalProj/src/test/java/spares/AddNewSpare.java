package spares;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpare extends ParentTest {

    String spareName = "koval";

    @Test
    public void addNewSpare(){
        loginPage.validLoginInToApp();
        homePage.checkUrl();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpare();
        sparesPage.checkUrl();
//       sparesPage.checkAndDeleteSpare(spareName);
        sparesPage.deletingSpareUntilPresent(spareName);
        sparesPage.clickOnAddButton();
        sparesEditPage.checkUrl();
        sparesEditPage.inputSpareName(spareName);
        sparesEditPage.selectSpareType("Механика1");
        sparesEditPage.clickCreateButton();
        checkExpectedResult("Spare wasn't added", sparesPage.isSpareInList(spareName));
    }
    @After
    public void spareDeleting(){
        sparesPage.deletingSpareUntilPresent(spareName);
    }

}
