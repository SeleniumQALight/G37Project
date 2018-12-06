package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by user on 04.12.2018.
 */
public class EditProvidersPage extends ParentPage {
    @FindBy(id = "prov_cus_proCustName") private WebElement providerNameInput;
    @FindBy(id = "prov_cus_proCustAddress") private WebElement providerAdressInput;
    @FindBy(id = "prov_cus_proCustPhone") private  WebElement providerPhoneInput;
    @FindBy(id = "prov_cus_proCustIsFl") private  WebElement checkBoxIsProviderPrivatePerson;
    @FindBy(id = "prov_cus_isOurFirm") private WebElement checkBoxisProviderOurFirm;
    @FindBy(name = "add") private WebElement buttonCreate;
    @FindBy(name = "delete") private WebElement buttonDelete;


    public EditProvidersPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/providers/edit");
    }

    public void enterProviderNameIntoInput(String providerName) {
        actionsWithOurElements.enterTextIntoElement(providerNameInput,providerName);
    }

    public void enterProviderAdressIntoInput(String providerAdress) {
        actionsWithOurElements.enterTextIntoElement(providerAdressInput,providerAdress);
    }

    public void enterProviderPhoneIntoInput(String providerPhone) {
        actionsWithOurElements.enterTextIntoElement(providerPhoneInput,providerPhone);
    }

    public void clickButtonCreate() {
        actionsWithOurElements.clickOnElement(buttonCreate);
    }

    public void setCheckboxPrivatePerson(String state) {
        actionsWithOurElements.setNeededStateToCheckBox(checkBoxIsProviderPrivatePerson, state);
    }

    public void setCheckboxOurFirm(String state) {
        actionsWithOurElements.setNeededStateToCheckBox(checkBoxisProviderOurFirm,state);
    }

    public void clickButtonDelete() {
        actionsWithOurElements.clickOnElement(buttonDelete);
    }
}
