package providers;

import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewProvider extends ParentTest {

    String provider = "konev";

    @Test
    public void addNewDealPart(){
        loginPage.validLoginInToApp();
        homePage.checkUrl();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuProviders();
        providerPage.checkUrl();
        providerPage.checkAndDeleteDealPart(provider);
        providerPage.addButtonClick();
        editProviderPage.enterProCustName(provider);
        editProviderPage.enterProCustAddr("Address");
        editProviderPage.enterProCustPhone("222-3-22");
        editProviderPage.setPrivatPersonCheckbox("check");
        editProviderPage.clickCreateButton();

        checkExpectedResult("Test failed! Provider PrivatePerson flag missed!",providerPage.checkPrivatePersonFlag(provider));
    }

    @After
    public void providerDelete(){
        providerPage.checkAndDeleteDealPart(provider);
    }

}
