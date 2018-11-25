package spares;

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
     sparePage.checkAndDeleteSpare(spareName);
     sparePage.cliclOnAddButton();
     editSparePage.enterSpareNameInToInput(spareName);
     editSparePage.selectSpareTypeInDD("Mеханика1");
     editSparePage.clickButtonCreate();

    }
}
