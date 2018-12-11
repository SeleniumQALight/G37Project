package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditProvidersPage extends Parent_page {
    public EditProvidersPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/providers/edit");
    }

    @FindBy (id = "prov_cus_proCustName")
    WebElement providerFNameInputField;

    @FindBy (id = "prov_cus_proCustAddress")
    WebElement providerCustAddressField;

    @FindBy (id = "prov_cus_proCustIsFl")
    WebElement checkboxIsProviderFizLitso;

    @FindBy (xpath = ".//button[@class = 'btn btn-info']")
    WebElement sozdatNewProviderButton;

    @FindBy (xpath = ".//button[@class='btn btn-danger pull-right']")
    WebElement deleteExistingProviderButton;

    public void enterProvidersFullName(String fNameValue, String addressValue) {
        actionsWithOurElements.enterTextIntoElement(providerFNameInputField, fNameValue);
        actionsWithOurElements.enterTextIntoElement(providerCustAddressField, addressValue);

    }

    public void checkFizLitsoCheckbox(String desiredCheckboxValue) {
        actionsWithOurElements.setNeededStateToCheckbox(checkboxIsProviderFizLitso,desiredCheckboxValue);
    }

    public void clickOnCreateProviderButton() {
        actionsWithOurElements.clickOnElement(sozdatNewProviderButton);

    }

    public void clickOnDeleteProviderButton() {
        actionsWithOurElements.clickOnElement(deleteExistingProviderButton);
    }
}
