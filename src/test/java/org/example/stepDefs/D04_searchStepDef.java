package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class D04_searchStepDef {
    // Create object from pom design pattern
    P03_homePage homePage = new P03_homePage();

    @When("user click on search field")
    public void userClickOnSearchField() {
        homePage.searchField.click();

    }

    @And("user enter product name {string} and click on search button")            //search by product name
    public void userEnterProductNameAndClickOnSearchButton(String searchName) throws InterruptedException {
        homePage.searchField.sendKeys(searchName);
        homePage.searchLBtn.click();
        Thread.sleep(500);
    }

    @And("user enter product sku{string} and click on search button")               //search by product sku
    public void userEnterProductSkuAndClickOnSearchButton(String searchSku) throws InterruptedException {
        homePage.searchField.sendKeys(searchSku);
        homePage.searchLBtn.click();
        Thread.sleep(500);
    }

    @Then("user will find all related products {string}")
    public void userWillFindAllRelatedProducts(String searchWord) {
        int counter = 0;                            // to count number of search result
        SoftAssert softAssert = new SoftAssert();

        //Scenario 1 assertion
        //1.1 - soft assertion verifying if contains url or not
        String actualSearchPageUrl = Hooks.driver.getCurrentUrl();
        String expectedSearchPageUrl = "https://demo.nopcommerce.com/search?q=";
        softAssert.assertTrue(actualSearchPageUrl.contains(expectedSearchPageUrl), "search assertion is failed");
        System.out.println(actualSearchPageUrl);      // get url for confirmation run

        //1.2.1 - search show Count number of search results
        //1.2.2 - search verify if each result contains the search word
        for (int i = 0; i < homePage.productTitle.size(); i++) {
            String checkResult = String.valueOf(homePage.productTitle.get(i).getText().toLowerCase().contains(searchWord));
            if (checkResult.equals("true")) {
                String productTitle = homePage.productTitle.get(i).getText().toLowerCase();
                Assert.assertTrue(productTitle.contains(searchWord));
                counter++;
            }
        }
        System.out.println("The number of related product search result is : " + counter);
        softAssert.assertAll();
    }


    @Then("user will find all related products by {string}")
    public void userWillFindAllRelatedProductsBy(String searchSku) {
        //Scenario 2 assertion :
        // 2.1 - getting the sku shown in this page and make sure it contains the sku that you are using in search
        homePage.searchField.sendKeys(searchSku);
        homePage.searchPic.click();                      // click on product picture displayed in page after sku search
        String actualSku = homePage.skuText.getText();   // get sku text
        System.out.println(actualSku);                    // get text for confirmation run

       Assert.assertEquals(actualSku,searchSku,"search sku assertion is failed");
        //Assert.assertTrue(actualSku.contains(searchSku),"search sku assertion is failed");
    }
}
