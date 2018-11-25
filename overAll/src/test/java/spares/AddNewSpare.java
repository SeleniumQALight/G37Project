package spares;

import org.junit.After;

import org.junit.Test;
import parenTest.ParentTest;

public class AddNewSpare extends ParentTest{
    String spareName = "radulenkoSpare";
    @Test
    public void addNewSpare(){
        loginPage.validLoginInToApp();
        homePage.checkUrl();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpare();
        sparePage.checkUrl();
//        sparePage.checkAndDeleteSpare(spareName);
        sparePage.deletingSpareUntilPresent(spareName);
        sparePage.clickOnAddButton();
        editSparePage.enterSpareNameInToInput(spareName);
        editSparePage.selectSpareTypeInDD("Механика1");
        editSparePage.clickButtonCreate();



    }

    @After
    public void sparesDeleting(){
        sparePage.deletingSpareUntilPresent(spareName);
    }

}
