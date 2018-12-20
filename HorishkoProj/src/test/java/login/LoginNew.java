package login;

import io.qameta.allure.*;
import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

public class LoginNew extends ParentTest {
    @Owner("testOwner")
    @Link("www.google.com")
    @Issue("NameOfIssue")
    @Severity(SeverityLevel.BLOCKER)

    @Test
    public void validLogin(){
        loginPage.openLoginPage();
        loginPage.enterLogin("Student");
        loginPage.enterPassword("909090");
        loginPage.clickButtonVhod();

        checkExpectedResult("Avatar is not present" ,
                homePage.isAvatarDisplayed());
    }

    @Test
    public void unvalidLogin(){
        loginPage.loginInToApp("Teacher", "906090");
        Assert.assertFalse("Avatar is not present" ,
                homePage.isAvatarDisplayed());
    }

//    @Test
//    public void unvalidLogin(){
//        loginPage.openLoginPage();
//        loginPage.enterLogin("Teacher");
//        loginPage.enterPassword("909090");
//        loginPage.clickButtonVhod();
//
//        Assert.assertFalse("Avatar is not present" ,
//                homePage.isAvatarDisplayed());
//    }
}
