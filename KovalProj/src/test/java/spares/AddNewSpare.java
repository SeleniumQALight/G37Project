package spares;

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
        sparesPage.checkAndDeleteSpare(spareName);
        sparesPage.clickOnAddButton();
        sparesEditPage.checkUrl();
        sparesEditPage.inputSpareName(spareName);
        sparesEditPage.selectSpareType("Механика1");
        sparesEditPage.clickCreateButton();

    }

}
