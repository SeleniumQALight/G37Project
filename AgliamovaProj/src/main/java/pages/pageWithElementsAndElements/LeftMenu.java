package pages.pageWithElementsAndElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Link;

@FindBy(xpath = "//ul[@class='sidebar-menu']")
public class LeftMenu extends ParentElements {

    @FindBy(xpath = "//li[@id='dictionary']/a")
    private Link menuDictionary;

    @FindBy(xpath = "//li[@id='workers']/a")
    private Link subMenuWorkers;
    @FindBy(id = "spares")
    private Link subMenuSpares;

    public LeftMenu(WebDriver webDriver) {
        super(webDriver);
    }


    public void clickOnMenuDictionsry() {
        actionsWithOurElements.clickOnElement(menuDictionary);
    }

    public void clickOnSubMenuSpares() {
        actionsWithOurElements.clickOnElement(subMenuSpares);
    }

    public void clickOnSubMenuWorkers(){
        actionsWithOurElements.clickOnElement(subMenuWorkers);
    }

}

