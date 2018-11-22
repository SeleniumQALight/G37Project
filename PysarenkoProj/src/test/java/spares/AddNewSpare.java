package spares;

import org.junit.Test;
import parentTest.Parent_Test;

public class AddNewSpare extends Parent_Test {

    String spareName = "pysarenkoSpare";


    @Test
    public void addNewSpare(){
        loginPage.validLoginIntoApp();
        homePage.checkUrl();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpare();
        sparePage.checkUrl();
        sparePage.checkAndDeleteSpare(spareName);
        sparePage.clickOnAddButton();
        editSparePage.enterSpareNameInToinput(spareName);
        editSparePage.selectSpareTypeInDD("Механика1");
        editSparePage.clickOnButtonCreate();
    }
}
