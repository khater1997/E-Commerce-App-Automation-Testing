package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

public class D02_loginStepDef {
    // Create object from pom design pattern
    P02_login login = new P02_login();                  // Create object from P01_login

    // 1 * Positive Scenario
    // 1.1 - login with valid email and password
    @Given("user go to login page")
    public void userGoToLoginPage() {
        login.loginLink.click();                         // go to login page
    }

    @When("user login with valid data {string} and {string}")
    public void userLoginWithAnd(String email, String pass) {
        login.email.sendKeys(email);                     // send email
        login.password.sendKeys(pass);                   // send password
    }

    @And("user press on login button")
    public void userPressOnLoginButton() {
        login.loginBtn.click();                            //click on login button
    }

    @Then("user login to the system successfully")
    public void userLoginToTheSystemSuccessfully() {
        //S01- assertion for verifying successful login and get login page url

        SoftAssert softAssert = new SoftAssert();

        //4.1 - first assertion : check and get login page url
        //softAssert.assertEquals(Hooks.driver.getCurrentUrl(),"https://demo.nopcommerce.com/");

        String actualLoginUrl = Hooks.driver.getCurrentUrl();
        String expectedLoginUrl = "https://demo.nopcommerce.com/";
        softAssert.assertEquals(actualLoginUrl, expectedLoginUrl);
        System.out.println(actualLoginUrl);                 // to confirm when run

        //4.2 - second assertion : "My account" tab isDisplayed
        //softAssert.assertTrue(Hooks.driver.findElement(By.cssSelector("div[class=\"header-links\"] a")).isDisplayed());

        softAssert.assertTrue(login.myAccIcon.isDisplayed());
        System.out.println(login.myAccIcon.getText());

        softAssert.assertAll();
    }

    // 2 * Negative Scenario
    // 2.1 - login with wrong email
    @When("user login with invalid data {string} and {string}")
    public void userLoginWithInvalidDataAnd(String email, String pass) {
        login.email.sendKeys(email);                      // send wrong email
        login.password.sendKeys(pass);                     //send right password
    }

    @Then("user could not login to the system")
    public void userCouldNotLoginToTheSystem() {
        //S02- assertion for verifying that error message contains "Login was unsuccessful."

        SoftAssert softAssert = new SoftAssert();

        //4.1 - first assertion : check if error message contains login was unsuccessful
        /* softAssert.assertTrue(Hooks.driver.findElement(
                By.cssSelector("div[class=\"message-error validation-summary-errors\"]")).getText()
                .contains("Login was unsuccessful."));*/

        String actualMsgTxt = login.errorMsg.getText();
        String expectedMsgTxt = "Login was unsuccessful.";
        softAssert.assertTrue(actualMsgTxt.contains(expectedMsgTxt),"first assertion is failed");
        System.out.println(actualMsgTxt);                    // get text for confirmation run

        //4.2 - second assertion :  the color of error message is red  "#e4434b"
        /* softAssert.assertEquals(Color.fromString(Hooks.driver.findElement(
                        By.cssSelector("div[class=\"message-error validation-summary-errors\"]"))
                        .getCssValue("color")).asHex(), "#e4434b");*/

        String actualMsgColor = Color.fromString(login.errorMsg.getCssValue("color")).asHex();
        String expectedMsgColor = "#e4434b";
        softAssert.assertEquals(expectedMsgColor, expectedMsgColor,"second assertion is failed");
        System.out.println(actualMsgColor);                   // get color as hex for confirmation run

        softAssert.assertAll();
    }
}
