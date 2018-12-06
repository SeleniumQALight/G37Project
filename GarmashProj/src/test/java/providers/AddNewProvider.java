package providers;

import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewProvider extends ParentTest {
    String providerName = "garmashProvider";

    @Test
    public void addNewProvider() {
        loginPage.validLoginInToApp();
        homePage.checkUrl();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuProviders();
        providersPage.checkUrl();
        providersPage.deletingProviderUntilPresent(providerName);
        providersPage.clickOnAddButton();
        editProvidersPage.enterProviderNameInToInput(providerName);
        editProvidersPage.enterProviderAddressInToInput("Address");
        editProvidersPage.enterProviderPhoneInToInput("Phone");
        editProvidersPage.checkCheckBoxPrivatePerson();
        editProvidersPage.checkCheckBoxOurFirm();
        editProvidersPage.clickButtonCreate();
        checkExpectedResult("Provider wasn't added", providersPage.isProviderInList(providerName));
        checkExpectedResult("Checkbox wasn't added", providersPage.getProviderLabelWithName(providerName).getText().equals("1"));
    }

    @After
    public void providerDeleting() {
        providersPage.deletingProviderUntilPresent(providerName);
    }
}
