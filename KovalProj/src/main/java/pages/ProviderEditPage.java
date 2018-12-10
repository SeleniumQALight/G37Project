package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProviderEditPage extends ParentPage {

    @FindBy (name = "delete")
    private WebElement buttonDelete;
    @FindBy (id = "prov_cus_proCustName")
    private WebElement inputProCustName;
    @FindBy (id = "prov_cus_proCustAddress")
    private WebElement inputProCustAddress;
    @FindBy (id = "prov_cus_proCustPhone")
    private WebElement inputProCustPhone;
    @FindBy (name = "add")
    private WebElement buttonCreate;
    @FindBy (id = "prov_cus_proCustIsFl")
    private WebElement checkBoxPrivatePerson;

    public ProviderEditPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/providers/edit");
    }

    public void clickOnDeleteButton(){
        actionsWithOurElements.clickOnElement(buttonDelete);
    }

    public void inputProCustName(String providerName){
        actionsWithOurElements.enterTextInToElement(inputProCustName, providerName);
    }

    public void inputProCustAddress(String proCustAddress) {
        actionsWithOurElements.enterTextInToElement(inputProCustAddress, proCustAddress);
    }

    public void inputProCustPhone(String proCustPhone) {
        actionsWithOurElements.enterTextInToElement(inputProCustPhone, proCustPhone);
    }

    public void clickCreateButton(){
        actionsWithOurElements.clickOnElement(buttonCreate);
    }

    public void checkPrivatPersonOption() {
        actionsWithOurElements.setNeededStateToCheckBox(checkBoxPrivatePerson, "check");
    }
}
