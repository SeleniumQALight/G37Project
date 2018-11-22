package spares;

import org.junit.Test;
import pages.HomePage;
import parentTeest.ParentTest;

/**
 * Created by 123 on 20.11.2018.
 */
public class AddNewSpare extends ParentTest{

    String spareName = "TeplovaSpare";


    @Test

    public void addNewSpares(){
        loginPage.openLoginPage();
        homePage.CheckUrl();
        homePage.clickOnMenuSpare();
        homePage.subMenuSpare();
        sparePage.CheckUrl();
        sparePage.checkAndDeleteSpare(spareName);
        sparePage.clickOnButton();
        editSparePage.enterSpareNameInToInput(spareName);
        editSparePage.selectSpareTypeInDD("Meckanika");
        editSparePage.clickButtonCreate();








    }
}
