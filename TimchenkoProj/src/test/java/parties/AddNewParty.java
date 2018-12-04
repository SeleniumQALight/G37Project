package parties;

import org.junit.After;
import org.junit.Test;
import pages.PartiesPage;
import parentTest.ParentTest;

public class AddNewParty extends ParentTest {
    String partyName = "tymchenkoParty";

    @Test
    public void addNewParty () {

        logInPage.validLogInIntoApp();
        homePage.checkUrl();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuParties();
        partiesPage.checkUrl();
        partiesPage.deletingPartiesUntilPresent(partyName);
        partiesPage.clickOnAddButton();
        editPartiesPage.enterPartyInToInput(partyName);
        editPartiesPage.enterAdressIntoInput("boychenko street");
        editPartiesPage.enterPhoneIntoInput("099990766");
        editPartiesPage.selectPrivatePersonInCheckBox("check");
        editPartiesPage.clickButtonCreate();


        expectedResult("Party was not added", partiesPage.isPartyInList(partyName));

    }


        @After

        public void deleteParty () {
           partiesPage.deletingPartiesUntilPresent(partyName);

        }



}
