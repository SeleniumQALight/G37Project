package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditProviderPage extends ParentPage{

    @FindBy(id = "prov_cus_proCustName")
    private WebElement providerNameInput;

    @FindBy(id = "prov_cus_proCustAddress")
    private WebElement providerAddressInput;

    @FindBy(id = "prov_cus_proCustPhone")
    private WebElement providerPhoneNumberInput;

    @FindBy(id = "prov_cus_proCustIsFl")
    private WebElement providerIsPrivatePersonCheckBox;

    @FindBy(id = "prov_cus_isOurFirm")
    private WebElement providerIsOurFirmCheckBox;

    @FindBy(xpath = "//button[text()='Создать']")
    private WebElement providerCreateButton;

    public EditProviderPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/providers/edit/");
    }

    public boolean isProviderNameEmpty(String providerName){
        return providerNameInput.getAttribute("value").equals(providerName);
    }

    public void enterProviderNameIntoInput(String providerName){
        actionsWithOurElements.enterTextIntoElement(providerNameInput, providerName);
    }

    public boolean isProviderAddressEmpty(String providerAddress){
        return providerAddressInput.getAttribute("value").equals(providerAddress);
    }

    public void enterProviderAddressIntoInput(String providerAddress){
        actionsWithOurElements.enterTextIntoElement(providerAddressInput, providerAddress);
    }

    public boolean isProviderPhoneEmpty(String providerPhone) {
        return providerPhoneNumberInput.getAttribute("value").equals(providerPhone);
    }

    public void enterProviderPhoneIntoInput(String providerPhone){
        actionsWithOurElements.enterTextIntoElement(providerPhoneNumberInput, providerPhone);
    }

    public void clickOnCheckboxPrivatePerson(){
        actionsWithOurElements.setNeededStateToCheckbox(providerIsPrivatePersonCheckBox,"checked");
    }

    public void clickOnCheckBoxIsOurFirm(){
        actionsWithOurElements.setNeededStateToCheckbox(providerIsOurFirmCheckBox,"checked");
    }

    public void clickOnCreateButton(){
        actionsWithOurElements.clickOnElement(providerCreateButton);
    }
}
