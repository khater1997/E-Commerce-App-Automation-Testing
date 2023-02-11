package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class P03_homePage {
    public P03_homePage() {
        PageFactory.initElements(Hooks.driver, this);
    }

    // currencies pom design pattern
    @FindBy(css = "select[name=\"customerCurrency\"]")
    public WebElement currencySelect;
    @FindBy(css = "span[class=\"price actual-price\"]")
    public List<WebElement> productPrice;

    // search pom design pattern
    @FindBy(css = "input[id=\"small-searchterms\"]")
    public WebElement searchField;
    @FindBy(css = "button[class=\"button-1 search-box-button\"]")
    public WebElement searchLBtn;
    @FindBy(css = "h2[class=\"product-title\"]")
    public List<WebElement> productTitle;
    @FindBy(css = "div[class=\"picture\"]")
    public WebElement searchPic;
    @FindBy(css = "div[class=\"sku\"] span[class=\"value\"]")
    public WebElement skuText;

    // hover category pom design pattern
    @FindBy(css = "ul[class=\"top-menu notmobile\"] a[href=\"/electronics\"]")
    public WebElement category;
    @FindBy(css = "ul[class=\"sublist first-level\"] a[href=\"/camera-photo\"]")
    public WebElement subCategory;
    @FindBy(css = "div[class=\"page-title\"] h1")
    public WebElement subCategoryTitle;

    // home slider pom design pattern
    @FindBy(css = "a[href=\"https://demo.nopcommerce.com/\"]")
    public WebElement homeSlider;
    @FindBy(css = "a[style=\"display: block;\"]")
    public WebElement secondHomeSlider;

    // follow us pom design pattern
    @FindBy(css = "a[href=\"http://www.facebook.com/nopCommerce\"]")
    public WebElement facebookIcon;
    @FindBy(css = "a[href=\"https://twitter.com/nopCommerce\"]")
    public WebElement twitterIcon;
    @FindBy(css = "a[href=\"/news/rss/1\"]")
    public WebElement rssIcon;
    @FindBy(css = "a[href=\"http://www.youtube.com/user/nopCommerce\"]")
    public WebElement youtubeIcon;

    // wishlist pom design pattern
    @FindBy(css = "div[data-productid=\"18\"] button[class=\"button-2 add-to-wishlist-button\"]")
    public WebElement htcWishlistBtn;
    @FindBy(css = "div[class=\"bar-notification success\"]")
    public WebElement successMsg;
    @FindBy(css = "div[class=\"header-links\"] a[href=\"/wishlist\"]")
    public WebElement wishlistLink;
    @FindBy(css = "input[class=\"qty-input\"]")
    public WebElement productQty;
}
