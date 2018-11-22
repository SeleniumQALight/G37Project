package spares;

import org.junit.Test;
import org.openqa.selenium.support.FindBy;
import pages.ParentPage;
import parentTest.ParentTest;

public class AddNewSpare extends ParentTest {
    String spareName= "tkachenkoSpare";

    @Test
    public void addNewSpare(){
        loginPage.validLoginInToApp();
        homePage.checkUrl();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpare();
        sparePage.checkUrl();
        sparePage.checkAndDeleteSpare(spareName);
        sparePage.clickOnAddButton();
        editSparePage.enterSpareNameInToInput(spareName);
        editSparePage.selectSpareTypeInDD("Механика1");
        editSparePage.clickOnButtonCreate();
    }
}
