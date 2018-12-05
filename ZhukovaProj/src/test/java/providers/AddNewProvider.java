package providers;

import org.junit.After;
import org.junit.Test;

import parentTest.ParentTest;

public class AddNewProvider extends ParentTest {
    String newProvider = "ZhukovaProvider";
    String newProviderAddress = "Address";

    String checkboxprivatPerson = "1";


    @Test
    public void addNewProvider(){
        loginPage.validLoginIntoApp();
        homePage.checkUrl();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuProviders();
        providersPage.checkUrl();
        providersPage.deletingProviderEssenceUntilPresent(newProvider, checkboxprivatPerson);

        providersPage.clickOnAddButton();
        editProvidersPage.enterProviderNameInToInput(newProvider);
        editProvidersPage.enterProviderAddressInToInput(newProviderAddress);
        editProvidersPage.selectCheckboxPrivatePerson();
        editProvidersPage.clickOnButtonCreate();
        checkExpectedResult("Provider was not added",  providersPage.isProviderInList(newProvider, checkboxprivatPerson));
    }
    @After
    public  void providerEssenceDeleting(){
        providersPage.deletingProviderEssenceUntilPresent(newProvider, checkboxprivatPerson);
    }



}
