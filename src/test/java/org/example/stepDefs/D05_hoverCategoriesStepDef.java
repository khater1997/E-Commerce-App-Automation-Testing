package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class D05_hoverCategoriesStepDef {
    // Create object from pom design pattern
    P03_homePage homePage = new P03_homePage();
    String subCategoryTxt;

    @When("user hover random category")
    public void userHoverRandomCategory() throws InterruptedException {
        // Create object from Actions class (in Selenium)
        Actions actions = new Actions(Hooks.driver);
        actions.moveToElement(homePage.category).perform();
        Thread.sleep(4000);
    }

    @And("user select sub category and click")
    public void userSelectSubCategoryAndClick() throws InterruptedException {
        // 4.1 - get the text of this sub-category
        subCategoryTxt = homePage.subCategory.getText();    // selecting random sub-category

        //4.2 - click on it
        homePage.subCategory.click();

    }

    @Then("sub category page appears")
    public void subCategoryPageAppears() {
        String actualSubCatTitle = homePage.subCategoryTitle.getText().toLowerCase().trim();  // sub-category title
        System.out.println(subCategoryTxt);

        // Assert that the sub-category title is (equal or contains) the selected random sub-category
        Assert.assertTrue(subCategoryTxt.toLowerCase().contains(actualSubCatTitle),"Assertion is failed");

    }
}
