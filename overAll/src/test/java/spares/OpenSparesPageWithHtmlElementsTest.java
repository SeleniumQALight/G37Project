package spares;

import org.junit.Test;
import parentTest.ParentTest;

public class OpenSparesPageWithHtmlElementsTest extends ParentTest {
    @Test
    public void openSparesPage(){
        loginPageWithHtmlElement.validLoginInToApp();
        homePageWithHtmlElements.leftMenu.clickOnMenuDictionsry();
        homePageWithHtmlElements.leftMenu.clickOnSubMenuSpares();
        sparePageWithHtmlElements.checkUrl();

        sparePageWithHtmlElements.leftMenu.clickOnSubMenuWorkers();
        workersPageWithHtmlElements.checkUrl();
        workersPageWithHtmlElements.leftMenu.clickOnSubMenuSpares();

        sparePageWithHtmlElements.checkUrl();






    }
}

