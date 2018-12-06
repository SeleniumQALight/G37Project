package spares;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import parentTeest.ParentTest;

/**
 * Created by 123 on 20.11.2018.
 */
public class AddNewSpare extends ParentTest{

    String spareName = "TeplovaSpare";


    @Test

    public void addNewSpares(){

        loginPage.validLogin();
        homePage.checkUrl();

        homePage.isAvatarPresent();

        homePage.clickOnMenuSpare();
        homePage.subMenuSpare();
        sparePage.checkUrl();

//        sparePage.checkAndDeleteSpare(spareName);
        sparePage.deletingSpareUntilPresent(spareName);
        sparePage.clickOnButtonAdd();
        editSparePage.enterSpareNameInToInput(spareName);
        editSparePage.selectSpareTypeInDD("Механика1");
        editSparePage.clickButtonCreate();

        checkExpactedResult("Spare was not added", sparePage.isSpareInList(spareName));

    }

    @After
    public void spareDeleting(){
        sparePage.deletingSpareUntilPresent(spareName);
    }
}
