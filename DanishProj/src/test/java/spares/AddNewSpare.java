package spares;

import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpare extends ParentTest {
    @Test
    public void addNewSpare(){
        loginPage.validLoginInToApp();
        homePage.checkUrl();
        homePage.clickOnMenuDictionaty();
        homePage.clickOnSubMenuSpare();
        sparePage.checkUrl();




    }

}
