package providers;

import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewProvider extends ParentTest {
    String providerName = "DominaProvider";
    String providerAddress = "Test street 51";
    String providerPhone = "1234567890";

    @Test
    public void addNewProvider(){
        loginPage.validLoginInToApp();
        homePage.checkUrl();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubmenuProviders();
        providersPage.checkUrl();
        providersPage.deletingProviderIfPresent(providerName);
        providersPage.clickOnAddButton();
        editProvidersPage.enterProviderNameInToInput(providerName);
        editProvidersPage.enterProviderAddressInToInput(providerAddress);
        editProvidersPage.enterProviderPhoneInToInput(providerPhone);
        editProvidersPage.checkPrivatePersonCheckBox();
        editProvidersPage.clickButtonCreate();

        checkExpectedResult("Provider was not added", providersPage.isInProvidersList(providerName));

    }

    @After
    public void ProviderDeleting(){
        providersPage.deletingProviderIfPresent(providerName);
    }


}
