package providers;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.support.FindBy;
import parentTest.ParentTest;

public class AddNewContragent extends ParentTest {
    String contrAgentName = "contragentNikitin";
    String contrAgentAddress = "contragentNikitin";
    String contraAgentPhone = "555666888";


    @Test
    public void addNewContragent(){
        loginPage.loginIntoApp("Student","909090");
        homePage.checkUrl();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuDealType();
        providerPage.checkUrl();
        providerPage.clickOnAddButton();
        editProviderPage.enterProviderNameIntoInput(contrAgentName);
        editProviderPage.enterProviderAddressIntoInput(contrAgentAddress);
        editProviderPage.enterProviderPhoneIntoInput(contraAgentPhone);
        editProviderPage.clickOnCheckboxPrivatePerson();
        editProviderPage.clickOnCheckBoxIsOurFirm();
        editProviderPage.clickOnCreateButton();

        checkExpectedResult("provider (contragent) wasn't added to the list", providerPage.isProviderInList(contrAgentName));
    }

//    @After
//    public void providerDeleting(){
//        providerPage.deletingUntilPresent(contrAgentName);
//    }
}
