package addProviders;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.Parent_Test;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)

public class AddProviders extends Parent_Test {

    String providerFName;
    String providerAddress;

    public AddProviders(String providerFName, String providerAddress) {
        this.providerFName = providerFName;
        this.providerAddress = providerAddress;
    }

    @Parameterized.Parameters(name = "Parameters are{0} and {1}")
    public static Collection testData(){
        return Arrays.asList(new Object[][]{
                {"Джигит1", "Мандариновая республика"},
                {"WonderWoman,Inc.","Cozy street 14,NY,USA"},
                {"1089s7ej", " ,owe 00"},

        });
    }

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
