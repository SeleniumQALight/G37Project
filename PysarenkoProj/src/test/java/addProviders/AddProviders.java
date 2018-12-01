package addProviders;

import org.junit.Test;
import parentTest.Parent_Test;

public class AddProviders extends Parent_Test {

    String providerFName = "Coala Fizlitso 100%";
    String providerAddress = "Hong-Kong";

    @Test
    public void addProviderAsFizLitso(){
        String desiredCheckboxValueChecked = "check";

        loginPage.loginInToApp("Student","909090");
        homePage.checkUrl();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuProviders();
        providersPage.checkUrl();
        providersPage.deleteCertainProviderUntilPresent(providerFName);
        providersPage.clickOnAddNewProvidersButton();
        editProvidersPage.enterProvidersFullName(providerFName,providerAddress);
        editProvidersPage.checkFizLitsoCheckbox(desiredCheckboxValueChecked);
        editProvidersPage.clickOnCreateProviderButton();
        providersPage.checkUrl();

        checkExpectedResult("Provider is NOT marked as FizLitso!",providersPage.isProoviderInListAsFizlitso(providerFName) );




    }
}
