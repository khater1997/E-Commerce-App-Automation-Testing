package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_register;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class D01_registerStepDef {
    // Create object from pom design pattern
    P01_register register = new P01_register();                         // Create object from P01_register

    @Given("user go to register page")
    public void userGoToRegisterPage() {
        register.registerLink.click();                                     // go to register page
    }

    @When("user select gender type")
    public void userSelectGenderType() {                                   // select gender type : male
        register.maleOption.click();
    }

    @And("user enter first name {string} and last name {string}")
    public void userEnterFirstNameAndLastName(String firstName, String lastName) {
        register.firstName.sendKeys(firstName);                           // send first name
        register.lastName.sendKeys(lastName);                              // send last name
    }

    @And("user enter date of birth  Step")
    public void userEnterDateOfBirthStep() {
        Select select = new Select(register.birthDay);                  // select the day of his birthDay
        select.selectByIndex(21);

        select = new Select(register.birthMonth);                        // select the month of his birth month
        select.selectByVisibleText("March");

        select = new Select(register.birthYear);                          // select the year of his birth year
        select.selectByValue("1997");

    }

    @And("user enter email {string} field")
    public void userEnterEmailField(String email) {                        // send email
        register.email.sendKeys(email);
        System.out.println(email);
    }

    @And("user fills Password fields {string} {string}")
    public void userFillsPasswordFields(String pass, String passConfirm) {
        register.password.sendKeys(pass);                                     // send password 
        register.passwordConfirm.sendKeys(passConfirm);                        // send confirmation password

    }

    @And("clicks on register button")
    public void clicksOnRegisterButton() {
        register.registerBtn.click();                                        // click on register button
    }

    @Then("success message is displayed")
    public void successMessageIsDisplayed() {

        // assertion for verifying success message and it's color
        SoftAssert softAssert = new SoftAssert();

        //8.1 - verify Success message is displayed "Your registration completed"
        softAssert.assertTrue(register.successMsg.getText().contains("Your registration completed"));

        //8.2 - verify success message color is green  (#4cb17c) hex
        softAssert.assertEquals(register.successMsg.getCssValue("color"), "rgba(76, 177, 124, 1)");
        System.out.println(register.successMsg.getCssValue("color"));
        softAssert.assertAll();
    }
}
