package spares;

import org.junit.Test;
import parentTest.Parent_Test;

public class AddNewSpare extends Parent_Test {
    @Test
    public void addNewSpare(){
        loginPage.validLoginIntoApp();
        homePage.checkUrl();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpare();
        sparePage.checkUrl();

    }
}
