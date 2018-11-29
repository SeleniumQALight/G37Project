package spares;

import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpare extends ParentTest {
    String spareName="gapachiloSpare";

    @Test

    public  void addNewSpare(){
      loginPage.validLoginInTOApp();
      homePage.checkUrl();
      homePage.clickMenuDictionary();
      homePage.clickOnSubMenuSpare();
      sparePage.checkUrl();
//      sparePage.checkAndDeleteSpare(spareName);
      sparePage.deletingSpareUntilPresent(spareName);
      sparePage.clickOnAddButton();
      editSparePage.enterSpareNameInTOInput(spareName);
      editSparePage.selectSpareTypeInDD("Механика1");
      editSparePage.clickButtonCreate();






    }
}
