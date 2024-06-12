package com.solvd.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginBasePage extends AbstractPage {

    @FindBy(id="user-name")
    private ExtendedWebElement loginField;
    @FindBy(id="password")
    private ExtendedWebElement passwordField;
    @FindBy(id = "login-button")
    private ExtendedWebElement loginButton;

    public LoginBasePage(WebDriver driver) {
        super(driver);
        setPageURL("");
    }

    private void typeUserLogin(String login) {
        loginField.type(login);
    }

    private void typeUserPassword(String password) {
        passwordField.type(password);
    }

    public void submitLogin() {
        loginButton.click();
    }
    public ProductListBasePage login(String login,String password){
        typeUserLogin(login);
        typeUserPassword(password);
        submitLogin();
        return initPage(driver,ProductListBasePage.class);
    }

}
