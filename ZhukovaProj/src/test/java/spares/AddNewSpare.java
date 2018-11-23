package spares;

import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpare extends ParentTest {

    String spareName ="zhukovaSpare";
    @Test
    public void addNewSpare(){
      loginPage.validLoginIntoApp();
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
