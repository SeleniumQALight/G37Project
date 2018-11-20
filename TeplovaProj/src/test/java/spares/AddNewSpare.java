package spares;

import org.junit.Test;
import pages.HomePage;
import parentTeest.ParentTest;

/**
 * Created by 123 on 20.11.2018.
 */
public class AddNewSpare extends ParentTest{

    @Test

    public void addNewSpares(){
        loginPage.openLoginPage();
        homePage.CheckUrl();
        homePage.clickOnMenuSpare();
        homePage.subMenuSpare();
        sparePage.CheckUrl();






    }
}
