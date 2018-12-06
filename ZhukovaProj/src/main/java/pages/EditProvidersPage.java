package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditProvidersPage extends ParentPage {



    public EditProvidersPage(WebDriver webDriver) {
        super(webDriver, "dictionary/providers/edit");
    }

    @FindBy(id="prov_cus_proCustName")
    WebElement customNameInput;

    @FindBy(id="prov_cus_proCustAddress")
    WebElement customAddressInput;

    @FindBy(xpath = ".//input[@id='prov_cus_proCustPhone']")
    WebElement customPhone;

    @FindBy(xpath = ".//input[@id='prov_cus_proCustIsFl']")
    WebElement checkBoxPrivatPerson;

    @FindBy(name="add")
    private WebElement buttonCreate;

    @FindBy(name="delete")
    WebElement buttonDelete;

    public void clickOnButtonCreate() {
        actionsWithOurElements.clickOnElement(buttonCreate);
    }

    public void selectCheckboxPrivatePerson() {
        actionsWithOurElements.selectCheckBox(checkBoxPrivatPerson);
    }

    public void enterProviderNameInToInput(String newProvider) {
        actionsWithOurElements.enterTextIntoElement(customNameInput, newProvider);

    }

    public void enterProviderAddressInToInput( String newProviderAddress) {
        actionsWithOurElements.enterTextIntoElement(customAddressInput,  newProviderAddress);
    }
    public void clickButtonDeleteOnEditProviderPage() {

        actionsWithOurElements.clickOnElement(buttonDelete);
    }
}
