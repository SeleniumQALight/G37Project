package providers;

import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewProvider extends ParentTest {

    String providerName = "koval";
    String proCustAddress = "alex";
    String proCustPhone = "0979998877";

    @Test
    public void addNewProvider(){
        loginPage.validLoginInToApp();
        homePage.checkUrl();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuProviders();
        providersPage.checkUrl();
        providersPage.deletingProviderUntilPresent(providerName);
        providersPage.clickOnAddButton();
        providerEditPage.checkUrl();
        providerEditPage.inputProCustName(providerName);
        providerEditPage.inputProCustAddress(proCustAddress);
        providerEditPage.inputProCustPhone(proCustPhone);
        providerEditPage.checkPrivatPersonOption();
        providerEditPage.clickCreateButton();
        checkExpectedResult("Provider wasn't added", providersPage.isProviderInList(providerName));
    }

    @After
    public void providerDeleting(){
        providersPage.deletingProviderUntilPresent(providerName);
    }
}

