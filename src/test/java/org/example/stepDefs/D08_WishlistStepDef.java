package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class D08_WishlistStepDef {
    // Create object from pom design pattern
    P03_homePage homePage = new P03_homePage();

    @When("user clicks on wishlist button on this product \\(HTC One M8 Android L5 Lollipop)")
    public void user_clicks_on_wishlist_button_on_this_product_htc_one_m8_android_l5_lollipop() {
        // Write code here that turns the phrase above into concrete actions

        homePage.htcWishlistBtn.click();                // click on heart button to add to wishlist
    }

    @Then("this product is added successfully to wishlist")
    public void this_product_is_added_successfully_to_wishlist() {
        // Write code here that turns the phrase above into concrete actions
        SoftAssert softAssert = new SoftAssert();

        //assertion check if success message is displayed
        softAssert.assertTrue(homePage.successMsg.isDisplayed());
        String successMsgColor = Color.fromString(homePage.successMsg.getCssValue("background-color")).asHex();

        //assertion check if success message background color is green
        softAssert.assertEquals(successMsgColor, "#4bb07a", "color assertion is failed");
        softAssert.assertAll();
    }

    @And("clicks on wishlist link")
    public void clicksOnWishlistLink() {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(homePage.successMsg));
        homePage.wishlistLink.click();             // click on wishlist button on header
    }

    @Then("verify the product is added successfully and product quantity is more than zero")
    public void verifyTheProductIsAddedSuccessfullyAndProductQuantityIsMoreThanZero() {

        int productQuantity = Integer.parseInt(homePage.productQty.getAttribute("value")); // get number of quantity

        //assertion check if product quantity more than 0
        Assert.assertTrue(productQuantity > 0, "quantity assertion is failed");

    }
}
