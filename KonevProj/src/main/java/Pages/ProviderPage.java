package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProviderPage extends ParentPage {

    EditProviderPage editProviderPage;

    public ProviderPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/providers");
        editProviderPage = new EditProviderPage(webDriver);
    }

    @FindBy(xpath = "//*[@class='fa fa-plus']")
    WebElement addButton;


    @FindBy(xpath = ".//table//tr//td[1]") //находит все элементы по этому икспасу и записывает в список
            List<WebElement> listOfProviders;

    public void checkAndDeleteDealPart(String provider) {

        int i = 0;
        while (actionsWithOurElements.isElementDisplayed(By.xpath("(//td[contains(.,'" + provider + "')])")) && i < 100) {
            actionsWithOurElements.clickOnElement(getProviderWithName(provider));
            editProviderPage.clickDeleteButton();
            logger.info("Provider " + provider + " successfully deleted");
            i++;
        }
        if (i>=100){
            logger.error("Provider table contains more then 100 records or bug with deleting provider record exist.");
        }
    }

    public boolean checkPrivatePersonFlag(String provider) {

        for (int i = 1; i <= listOfProviders.size(); i++) {
            if (listOfProviders.get(i).getText().equals(provider)) {
                if (webDriver.findElement(By.xpath("(//span[@class='label label-success'])[" + String.valueOf(i + 1) + "]")).getText().equals("1")) {
                    logger.info("Provider " + provider + " PrivatePerson flag is On.");
                    return true;
                } else {
                    logger.info("Provider " + provider + " PrivatePerson flag is not set.");
                    return false;
                }
            }
        }
        logger.error("Provider " + provider + " wasn't found." + " PrivatePersonFrag couldn't be checked");
        return false;
    }

    public void addButtonClick() {
        actionsWithOurElements.clickOnElement(addButton);
    }


    public WebElement getProviderWithName(String provider) {
        return webDriver.findElement(By.xpath("(//td[contains(.,'" + provider + "')])"));
    }
}
