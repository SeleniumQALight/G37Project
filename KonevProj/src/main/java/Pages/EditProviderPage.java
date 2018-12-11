package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditProviderPage extends ParentPage {
    public EditProviderPage(WebDriver webDriver) {
        super(webDriver, "dictionary/providers/edit/");
    }

    @FindBy(xpath = "//input[@id='prov_cus_proCustName']")
    WebElement proCustName;

    @FindBy(xpath = "//input[@id='prov_cus_proCustAddress']")
    WebElement proCustAddr;

    @FindBy(xpath = "//input[@id='prov_cus_proCustPhone']")
    WebElement proCustPhone;

    @FindBy(xpath = "//input[@id='prov_cus_proCustIsFl']")
    WebElement privatePersonCheckbox;

    @FindBy(xpath = "//input[@id='prov_cus_isOurFirm']")
    WebElement isOurFirmCheckbox;

    @FindBy(xpath = "//button[@name='delete']")
    WebElement deleteButton;

    @FindBy(xpath = "//button[@name='save']")
    WebElement saveButton;

    @FindBy(xpath = "//*[@class='btn btn-info']")
    WebElement createButton;

    public void enterProCustName(String text) {
        actionsWithOurElements.enterTextInToElement(proCustName, text);
    }

    public void enterProCustAddr(String text) {
        actionsWithOurElements.enterTextInToElement(proCustAddr, text);
    }

    public void enterProCustPhone(String text) {
        actionsWithOurElements.enterTextInToElement(proCustPhone, text);
    }

    public void setPrivatPersonCheckbox(String text){
        actionsWithOurElements.setNeededStateToCheckBox(privatePersonCheckbox,text);
    }

    public void setIsOurFirmCheckbox(String text){
        actionsWithOurElements.setNeededStateToCheckBox(isOurFirmCheckbox,text);
    }

    public void clickDeleteButton(){
        actionsWithOurElements.clickOnElement(deleteButton);
    }

    public  void clickCreateButton(){
        actionsWithOurElements.clickOnElement(createButton);
    }

    public void clickSaveButton(){
        actionsWithOurElements.clickOnElement(saveButton);
    }

}
