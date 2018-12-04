package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditProvidersPage extends ParentPage {
    @FindBy(id = "prov_cus_proCustName")
    private WebElement ProCustNameInput;
    @FindBy(id = "prov_cus_proCustAddress")
    private WebElement ProCustAddressInput;
    @FindBy(id = "prov_cus_proCustPhone")
    private WebElement ProCustPhoneInput;
    @FindBy(xpath = "//*[@id='prov_cus_proCustIsFl']")
    private WebElement ProCustIsFlCheckbox;
    @FindBy(xpath = "//*[@id='prov_cus_isOurFirm']")
    private WebElement ProCustIsOurFirmCheckbox;
    @FindBy(name = "save")
    private WebElement buttonSave;

    @FindBy(name = "delete")
    private WebElement buttonDelete;

    @FindBy(name = "add")
    private WebElement buttonCreate;

    public EditProvidersPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/providers/edit");
    }

    public boolean checkProviderNameInInput(String providerName) {
        return ProCustNameInput.getAttribute("value").equals(providerName);
    }

    public void clickButtonDelete() {
        actionsWithOurElements.clickOnElement(buttonDelete);
    }

    public void enterProviderNameInToInput(String providerName) {
        actionsWithOurElements.enterTextInToElement(ProCustNameInput, providerName);
    }

    public void enterProviderAddressInToInput(String providerAddress) {
        actionsWithOurElements.enterTextInToElement(ProCustAddressInput, providerAddress);
    }

    public void enterProviderPhoneInToInput(String providerPhone) {
        actionsWithOurElements.enterTextInToElement(ProCustPhoneInput, providerPhone);
    }

    public void checkCheckBoxPrivatePerson() {
        actionsWithOurElements.setNeedeStateToCheckBox(ProCustIsFlCheckbox, "check");
    }

    public void checkCheckBoxOurFirm() {
        actionsWithOurElements.setNeedeStateToCheckBox(ProCustIsOurFirmCheckbox, "check");
    }

    public void clickButtonCreate() {
        actionsWithOurElements.clickOnElement(buttonCreate);
    }


}
