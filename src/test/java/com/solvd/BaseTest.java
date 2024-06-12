package com.solvd;

import com.solvd.components.MainNavigationMenu;
import com.solvd.components.ProductCatalog;
import com.solvd.components.SortOrder;
import com.solvd.pages.common.*;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class BaseTest extends AbstractTest {

    @Test(threadPoolSize = 1, invocationCount = 1)
    public void ProductSorting() {
        LoginBasePage loginPage = new LoginBasePage(getDriver());
        loginPage.open();
        ProductListBasePage productListingPage = loginPage.login(R.TESTDATA.get("valid_user"), R.TESTDATA.get("valid_password"));
        ProductCatalog productCatalog = productListingPage.getProductCatalog();

        Assert.assertTrue(productCatalog.areProductsDisplayed(), "Products should be visibly listed before sort operation.");

        Assert.assertTrue(productCatalog.sortAndVerify(SortOrder.PRICE_LOW_TO_HIGH),
                "Products should be sorted in ascending order by price.");

        Assert.assertTrue(productCatalog.sortAndVerify(SortOrder.PRICE_HIGH_TO_LOW),
                "Products should be sorted in descending order by price.");

        Assert.assertTrue(productCatalog.sortAndVerify(SortOrder.A_TO_Z),
                "Products should be sorted alphabetically from A to Z.");

        Assert.assertTrue(productCatalog.sortAndVerify(SortOrder.Z_TO_A),
                "Products should be sorted alphabetically from Z to A.");
    }

    @Test(threadPoolSize = 1, invocationCount = 1)
    public void addItemsToCart() {
        LoginBasePage loginPage = new LoginBasePage(getDriver());
        loginPage.open();
        ProductListBasePage productListingPage = loginPage.login(R.TESTDATA.get("valid_user"), R.TESTDATA.get("valid_password"));
        ProductCatalog productCatalog = productListingPage.getProductCatalog();
        assertTrue(productCatalog.areProductsDisplayed(), "All products should be on display before cart operations.");
        assertTrue(productCatalog.areAddToCartButtonsVisible(), "An 'Add to Cart' option is expected for each product.");
        productCatalog.addAllItemsToCart();
        assertTrue(productCatalog.areRemoveFromCartButtonsVisible(), "Post-addition, 'Remove' options should replace 'Add to Cart' buttons.");
        int totalProductsAdded = productCatalog.getProductList().size();
        MainNavigationMenu navigationMenu = productListingPage.getMainNavigationMenu();
        ShoppingCartBasePage cartPage = navigationMenu.navigateToShoppingCart();
        List<ProductCatalog> cartProducts = cartPage.getShoppingCartItems();
        assertEquals(totalProductsAdded, cartProducts.size(), "The cart should contain a product count equal to the number added.");
    }

    @Test(threadPoolSize = 1, invocationCount = 1)
    public void checkout() {
        LoginBasePage loginPage = new LoginBasePage(getDriver());
        loginPage.open();
        ProductListBasePage productListingPage = loginPage.login(R.TESTDATA.get("valid_user"), R.TESTDATA.get("valid_password"));
        ProductCatalog productCatalog = productListingPage.getProductCatalog();
        productCatalog.addAllItemsToCart();
        MainNavigationMenu navigationMenu = productListingPage.getMainNavigationMenu();
        ShoppingCartBasePage cartPage = navigationMenu.navigateToShoppingCart();
        CheckoutDetailsBasePage checkoutDetailsPage = cartPage.proceedToCheckout();
        OrderSummaryBasePage orderSummaryPage = checkoutDetailsPage.completeCheckoutProcess(
                R.TESTDATA.get("first_name"),
                R.TESTDATA.get("last_name"),
                R.TESTDATA.get("code")
        );
        orderSummaryPage.finalizeOrder();
        assertTrue(orderSummaryPage.isOrderCompletionDisplayed(), "A confirmation of order completion should be visibly presented.");
    }
}

