package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditPartiesPage extends ParentPage{

    @FindBy(id = "prov_cus_proCustName")
   private WebElement partyNameInput;
    @FindBy (id = "prov_cus_proCustAddress")
    private WebElement adressNameInput;
    @FindBy(id= "prov_cus_proCustPhone")
    private WebElement phoneNumberInput;
    @FindBy (xpath = ".//*[@id='prov_cus_proCustIsFl']")
    private WebElement privateCheckBox;
    @FindBy  (name = "add")
    private WebElement buttonCreate;
    @FindBy (name = "delete")
    private WebElement butttonDelete;


    public EditPartiesPage(WebDriver webDriver) { super(webDriver, "/dictionary/providers/edit"); }



    public boolean checkPartyNameInInput (String partyName) { return partyNameInput.getAttribute("value").equals(partyName); }
    public void enterPartyInToInput(String partyName) { actionsWithOurElements.enterTextIntoElement(partyNameInput,partyName); }
    public  void enterAdressIntoInput (String adress) {actionsWithOurElements.enterTextIntoElement(adressNameInput,adress);}
    public  void enterPhoneIntoInput (String phoneNumber) {actionsWithOurElements.enterTextIntoElement(phoneNumberInput,phoneNumber);}
    public  void selectPrivatePersonInCheckBox (String check) {actionsWithOurElements.setNeededStateToCheckBox(privateCheckBox, check);}
    public void clickButtonCreate() { actionsWithOurElements.clickOnElement(buttonCreate);}
    public void clickButtonDelete () { actionsWithOurElements.clickOnElement(butttonDelete); }



    }
