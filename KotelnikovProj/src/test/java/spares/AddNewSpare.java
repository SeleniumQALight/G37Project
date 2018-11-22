package spares;

import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpare extends ParentTest {
    @Test
    public void addNewSpare(){
        loginPage.validLoginIntoApp();
        homePage.checkUrl();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpare();
        sparePage.checkUrl();
    }
}
