package providers;

import org.junit.After;
import org.junit.Test;

import parentTest.ParentTest;

public class AddNewProvider extends ParentTest {



    @Test
    public void addNewProvider(){
        loginPage.validLoginIntoApp();
        homePage.checkUrl();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuProviders();
        providersPage.checkUrl();
        providersPage.deletingProviderEssenceUntilPresent();

        providersPage.clickOnAddButton();
        editProvidersPage.enterProviderNameInToInput();
        editProvidersPage.enterProviderAddressInToInput();
        editProvidersPage.selectCheckboxPrivatePerson();
        editProvidersPage.clickOnButtonCreate();
        checkExpectedResult("Provider was not added",  providersPage.isProviderInList());
    }
    @After
    public  void providerEssenceDeleting(){
        providersPage.deletingProviderEssenceUntilPresent();
    }



}
