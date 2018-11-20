package spares;

import org.junit.Test;
import org.openqa.selenium.support.FindBy;
import pages.ParentPage;
import parentTest.ParentTest;

public class AddNewSpare extends ParentTest {
    @Test
    public void addNewSpare(){
        loginPage.validLoginInToApp();
        homePage.checkUrl();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpare();
        sparePage.checkUrl();

    }
}
