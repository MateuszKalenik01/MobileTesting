package com.solvd.pages.common;

import com.solvd.components.ProductCatalog;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public abstract class ShoppingCartBasePage extends AbstractCatalogMenuPage {

    @FindBy(xpath = "//div[@data-test='cart-list']//div[@data-test='inventory-item']")
    private List<ProductCatalog> shoppingCartItems;
    @FindBy(id = "checkout")
    private ExtendedWebElement checkoutButton;

    public ShoppingCartBasePage(WebDriver driver) {
        super(driver);
    }

    public CheckoutDetailsBasePage proceedToCheckout() {
        checkoutButton.click();
        return initPage(driver, CheckoutDetailsBasePage.class);
    }
}