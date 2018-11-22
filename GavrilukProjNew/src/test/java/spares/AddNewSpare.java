package spares;

import org.junit.Test;
import parenTest.ParentTest;

public class AddNewSpare extends ParentTest{
    @Test
    public void addNewSpare(){
        loginPage.validLoginInToApp();
        homePage.checkUrl();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpare();
        sparePage.checkUrl();


    }

}