package spares;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import parentTest.Parent_Test;

public class AddNewSpare extends Parent_Test {

    String spareName = "pysarenkoSpare";


    @Test
    public void addNewSpare(){
        loginPage.validLoginIntoApp();
        homePage.checkUrl();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpare();
        sparePage.checkUrl();
//        sparePage.checkAndDeleteSpare(spareName);
        sparePage.deletingSpareUntilPresent(spareName);
        sparePage.clickOnAddButton();
        editSparePage.enterSpareNameInToinput(spareName);
        editSparePage.selectSpareTypeInDD("Механика1");
        editSparePage.clickOnButtonCreate();

        checkExpectedResult("Spare wasn't added to list", sparePage.isSpareInList(spareName));

//        Assert.assertTrue("Spare wasn't added to list", sparePage.isSpareInList(spareName));

    }


    @After
    public void spareDeleting(){
        sparePage.deletingSpareUntilPresent(spareName);


    }
}
