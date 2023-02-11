package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.testng.Assert;

public class D06_homeSlidersStepDef {
    // Create object from pom design pattern
    P03_homePage homePage = new P03_homePage();

    @When("user press on first home slider iphone")
    public void userPressOnFirstHomeSliderIphone(){
        homePage.homeSlider.click();

    }

    @Then("user redirect to iphone page")
    public void userRedirectToIphonePage() throws InterruptedException {

        Thread.sleep(2000);
        String actualSliderUrl = Hooks.driver.getCurrentUrl();
        System.out.println(actualSliderUrl);                          // to confirm when run
        String expectedSliderUrl="https://demo.nopcommerce.com/iphone-14";

        // Assertion confirm that user couldn't redirect to iphone page and still in home page after pressing on slider
        Assert.assertEquals(actualSliderUrl,expectedSliderUrl,"Iphone assertion is failed");
    }

    @When("user press on first home slider galaxy")
    public void userPressOnFirstHomeSliderGalaxy() throws InterruptedException {
        Thread.sleep(4000);
        homePage.secondHomeSlider.click();
    }

    @Then("user redirect to galaxy page")
    public void userRedirectToGalaxyPage() throws InterruptedException {

        Thread.sleep(2000);
        String actualSliderUrl = Hooks.driver.getCurrentUrl();
        System.out.println(actualSliderUrl);                         // to confirm when run
        String expectedSliderUrl="https://demo.nopcommerce.com/galaxy-22";

        // Assertion confirm that user couldn't redirect to galaxy page and still in home page after pressing on slider
        Assert.assertEquals(actualSliderUrl,expectedSliderUrl,"Galaxy assertion is failed");

    }
}
