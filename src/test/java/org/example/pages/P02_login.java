package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P02_login {
    public P02_login() {
        PageFactory.initElements(Hooks.driver, this);
    }

    @FindBy(className = "ico-login")
    public WebElement loginLink;

    @FindBy(id = "Email")
    public WebElement email;

    @FindBy(id = "Password")
    public WebElement password;

    @FindBy(css = "button[class=\"button-1 login-button\"]")
    public WebElement loginBtn;

    @FindBy(className = "ico-account")
    public WebElement myAccIcon;

    @FindBy(css = "div[class=\"message-error validation-summary-errors\"]")
    public WebElement errorMsg;
}
