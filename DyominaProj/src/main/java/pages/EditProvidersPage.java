package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditProvidersPage extends ParentPage {
    @FindBy (name="delete")
    private WebElement buttonDelete;

    @FindBy (xpath = "//*[@id='prov_cus_proCustName']")
    private WebElement providersNameInput;

    @FindBy (id="prov_cus_proCustAddress")
    private WebElement providerInputAddress;

    @FindBy (id="prov_cus_proCustPhone")
    private WebElement providerPhoneInput;

    @FindBy (id="prov_cus_proCustIsFl")
    private WebElement checkCheckbox;

    @FindBy (xpath="//*[@class='btn btn-info']")
    private WebElement buttonCreate;

    public EditProvidersPage(WebDriver webDriver) {
        super(webDriver, "dictionary/providers/edit");
    }

    public void clickButtonDelete() {
        actionsWithOurElements.clickOnElement(buttonDelete);
    }

    public boolean checkProviderNameInInput(String providerName) {
        return providersNameInput.getAttribute("value").equals(providerName);
    }

    public void enterProviderNameInToInput(String providerName) {
        actionsWithOurElements.enterTextIntoElement(providersNameInput, providerName);
    }

    public void enterProviderAddressInToInput(String providerAddress) {
        actionsWithOurElements.enterTextIntoElement(providerInputAddress, providerAddress);
    }

    public void enterProviderPhoneInToInput(String providerPhone) {
        actionsWithOurElements.enterTextIntoElement(providerPhoneInput, providerPhone);
    }

    public void checkPrivatePersonCheckBox() {
        actionsWithOurElements.setNeededStateToCheckBox(checkCheckbox, "check");
    }

    public void clickButtonCreate() {
        actionsWithOurElements.clickOnElement(buttonCreate);
    }
}
