package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class D03_currenciesStepDef {
    // Create object from pom design pattern
    P03_homePage homePage = new P03_homePage();

    @When("user select currency type and choose Euro")
    public void userSelectCurrencyTypeAndChooseEuro() {
        Select dropList = new Select(homePage.currencySelect);
        dropList.selectByVisibleText("Euro");
    }

    @Then("verify Euro Symbol \\(€) is shown on the four products displayed in Home page")
    public void verifyEuroSymbol€IsShownOnTheProductsDisplayedInHomePage() {
        for (int i = 0; i <homePage.productPrice.size(); i++) {
            String actualPriceCurrency = homePage.productPrice.get(i).getText();
            System.out.println(actualPriceCurrency);

            // hard assertion to check if price contain euro sign
             Assert.assertTrue(actualPriceCurrency.contains("€"),"assertion is failed");

        }

    }
}
