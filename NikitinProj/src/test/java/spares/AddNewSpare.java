package spares;

import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpare extends ParentTest {
    String spareName = "nikitinSpare";

    @Test
    public void addNewSpare(){
        loginPage.loginIntoApp("Student","909090");
        homePage.checkUrl();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpare();
        sparePage.checkUrl();
        sparePage.checkAndDeleteSpare(spareName);
        sparePage.clickOnAddButton();
        editSparePage.enterSpareNameIntoInput(spareName);
        //editSparePage.selectSpareTypeInDD("Механика1");
        editSparePage.selectSpareTypeInDDByText("Механика1");
        editSparePage.clickButtonCreate();

    }
}
