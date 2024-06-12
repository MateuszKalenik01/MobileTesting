package com.solvd.components;

import com.solvd.pages.common.LoginBasePage;
import com.solvd.pages.common.OrderSummaryBasePage;
import com.solvd.pages.common.ShoppingCartBasePage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import lombok.Getter;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Getter
public class MainNavigationMenu extends AbstractUIObject {
    @FindBy(id = "react-burger-menu-btn")
    private ExtendedWebElement menuToggleButton;
    @FindBy(id = "shopping_cart_container")
    private ExtendedWebElement shoppingCartButton;
    @FindBy(id = "logout_sidebar_link")
    private ExtendedWebElement logoutLink;

    public MainNavigationMenu(WebDriver driver) {
        super(driver);
    }

    public ShoppingCartBasePage navigateToShoppingCart() {
        shoppingCartButton.click();
        return initPage(driver, ShoppingCartBasePage.class);

    }

    public LoginBasePage signOut() {
        menuToggleButton.click();
        waitUntil(ExpectedConditions.visibilityOf(logoutLink), 10);
        logoutLink.click();
        return initPage(driver, LoginBasePage.class);
    }
}
