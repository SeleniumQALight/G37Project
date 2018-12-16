package spares;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpares extends ParentTest {
    String spareName = "dilyaSpaer";
    @Test
    public void addNewSpare (){
        logInPage.validLoginInToApp();
        homePage.checkUrl();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpares();
        sparePage.checkUrl();
//        sparePage.checkAndDeleteSpare(spareName);
        sparePage.deletiSpareUntilPresent(spareName);
        sparePage.clickOnAddButton();
        editSparePage.enterSpareNameInToInput(spareName);
        editSparePage.selectSpareTypeInDD("Механика");
        editSparePage.clickButtonCreate();

        checkExpectedResult("Spare was not added", sparePage.isSpareInList(spareName));
    }

    @Test
    public void addNewSpareManual (){
        logInPage.validLoginInToApp();
        homePage.checkUrl();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpares();
        sparePage.checkUrl();
//        sparePage.checkAndDeleteSpare(spareName);
        sparePage.deletiSpareUntilPresent(spareName);
        sparePage.clickOnAddButton();
        editSparePage.enterSpareNameInToInput(spareName);
        editSparePage.selectSpareTypeInDDManual("Механика");
        editSparePage.clickButtonCreate();

        checkExpectedResult("Spare was not added", sparePage.isSpareInList(spareName));
    }

    @After
    public void spareDeleting (){
        sparePage.deletiSpareUntilPresent(spareName);
    }
}
