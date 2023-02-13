package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;

public class D07_followUsStepDef {
    // Create object from pom design pattern
    P03_homePage homePage = new P03_homePage();
    ArrayList<String> tabs;

    @When("user click on facebook icon")
    public void userClickOnFacebookIcon() {
        //S1.1 - click on facebook
        homePage.facebookIcon.click();

        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        //S1.2 - get window list inside array
        tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
    }

    @Then("user navigate to facebook page {string} and opened in new tab")
    public void userNavigateToFacebookPageAndOpenedInNewTab(String expectedFacebookUrl) throws InterruptedException {
        Thread.sleep(2000);
        //S1.3 - switch from tab 0 to tab 1
        Hooks.driver.switchTo().window(tabs.get(1));
        String actualFacebookUrl = Hooks.driver.getCurrentUrl();     //get tab 1 (facebook page) url
        System.out.println(actualFacebookUrl);                         // to confirm when run

        //assertion check if actual facebook page url equal expected one
        Assert.assertEquals(actualFacebookUrl, expectedFacebookUrl, "facebook assertion is failed");
    }

    @When("user click on twitter icon")
    public void userClickOnTwitterIcon() {
        //S2.1 - click on twitter
        homePage.twitterIcon.click();                               // press on twitter icon

        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        //S2.2 - get window list inside array
        tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
    }

    @Then("user navigate to twitter page {string} and opened in new tab")
    public void userNavigateToTwitterPageAndOpenedInNewTab(String expectedTwitterUrl) throws InterruptedException {
        Thread.sleep(2000);
        //S2.3 - switch from tab 0 to tab 1
        Hooks.driver.switchTo().window(tabs.get(1));
        String actualTwitterUrl = Hooks.driver.getCurrentUrl();     //get tab 1 (twitter page) url
        System.out.println(actualTwitterUrl);                         // to confirm when run


        //assertion check if actual twitter page url equal expected one
        Assert.assertEquals(actualTwitterUrl, expectedTwitterUrl, "twitter assertion is failed");
    }

    @When("user click on rss icon")
    public void userClickOnRssIcon() {
        //S3.1 - click on rss
        homePage.rssIcon.click();                               // press on rss icon

        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        //S3.2 - get window list inside array
        tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
    }

    @Then("user navigate to rss page {string} and opened in new tab")
    public void userNavigateToRssPageAndOpenedInNewTab(String expectedRssUrl) throws InterruptedException {
        Thread.sleep(2000);
        //S3.3 - switch from tab 0 to tab 1
        Hooks.driver.switchTo().window(tabs.get(1));
        String actualRssUrl = Hooks.driver.getCurrentUrl();     //get tab 1 (rss page) url
        System.out.println(actualRssUrl);                         // to confirm when run

        //assertion check if actual rss page url equal expected one
        Assert.assertEquals(actualRssUrl, expectedRssUrl, "rss assertion is failed");
    }

    @When("user click on youtube icon")
    public void userClickOnYoutubeIcon() {
        //S4.1 - click on youtube
        homePage.youtubeIcon.click();                               // press on youtube icon

        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        //S4.2 - get window list inside array
        tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
    }

    @Then("user navigate to youtube page {string} and opened in new tab")
    public void userNavigateToYoutubePageAndOpenedInNewTab(String expectedYoutubeUrl) throws InterruptedException {
        Thread.sleep(2000);
        //S4.3 - switch from tab 0 to tab 1
        Hooks.driver.switchTo().window(tabs.get(1));
        String actualYoutubeUrl = Hooks.driver.getCurrentUrl();     //get tab 1 (youtube page) url
        System.out.println(actualYoutubeUrl);                         // to confirm when run


        //assertion check if actual youtube page url equal expected one
        Assert.assertEquals(actualYoutubeUrl, expectedYoutubeUrl, "youtube assertion is failed");
    }
}