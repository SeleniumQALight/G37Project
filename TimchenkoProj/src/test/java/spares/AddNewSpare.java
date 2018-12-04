package spares;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpare extends ParentTest {
    String spareName = "tymchenkoSpare";

    @Test
    public void addNewSpare () {

        logInPage.validLogInIntoApp();
        homePage.checkUrl();
        homePage.clickOnMenuDictionary ();
        homePage.clickOnSubMenuSpare ();
        sparePage.checkUrl();
      //  sparePage.checkAndDeleteSpare(spareName);
        sparePage.deletingSpareUntilPresent (spareName);
        sparePage.clickOnAddButton();
        editSparePage.enterSpareInToInput (spareName);
        editSparePage.selectSpareTypeInDropDown ("Механика1");
        editSparePage.clickButtonCreate();

       expectedResult("Spare was not added", sparePage.isSpareInList(spareName));

    }

    @After

    public void deleteSpare () {
        sparePage.deletingSpareUntilPresent(spareName);

    }



}
