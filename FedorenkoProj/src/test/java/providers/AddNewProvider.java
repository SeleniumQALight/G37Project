package providers;

import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;

/**
 * Created by user on 04.12.2018.
 */
public class AddNewProvider extends ParentTest {
    String providerName = "Fedorenko provider";
    String providerAdress = "Kiyv_test";
    String providerPhone = "1234567";

    @Test
    public void addNewProvider() {
        loginPage.validLoginInToApp();
        homePage.checkUrl();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuProviders();
        providersPage.checkUrl();
        providersPage.deletingProviderUntilPresent(providerName);
        providersPage.clickOnAddButton();
        editProvidersPage.enterProviderNameIntoInput(providerName);
        editProvidersPage.enterProviderAdressIntoInput(providerAdress);
        editProvidersPage.enterProviderPhoneIntoInput(providerPhone);
        editProvidersPage.setCheckboxPrivatePerson("check");
        editProvidersPage.setCheckboxOurFirm("uncheck");
        editProvidersPage.clickButtonCreate();

        checkExpectedResult("Provider was not added", providersPage.isProviderInList(providerName));
    }

    @After
    public void spareDeleting() {
        providersPage.deletingProviderUntilPresent(providerName);
    }


}
