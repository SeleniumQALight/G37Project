package spares;

import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpare extends ParentTest {
    @Test

    public  void addNewSpare(){
      loginPage.validLoginInTOApp();
      homePage.checkUrl();
      homePage.clickMenuDictionary();
      homePage.clickOnSubMenuSpare();
      sparePage.checkUrl();

    }
}
