package com.solvd.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ProductCatalog extends AbstractUIObject {

    @FindBy(className = "inventory_item")
    private List<ProductCatalog> productList;

    @FindBy(xpath = ".//*[@class = 'inventory_item_name']")
    private ExtendedWebElement itemNameElement;

    @FindBy(xpath = ".//*[@class = 'inventory_item_price']")
    private ExtendedWebElement itemPriceElement;

    @FindBy(xpath = ".//*[@class = 'inventory_item_name ']")
    private ExtendedWebElement productNameText;

    @FindBy(xpath = ".//*[@class = 'inventory_item_price']")
    private ExtendedWebElement productPriceText;

    @FindBy(xpath = ".//*[@class = 'btn btn_primary btn_small btn_inventory ']")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = ".//*[@class = 'btn btn_secondary btn_small btn_inventory ']")
    private ExtendedWebElement removeFromCartButton;

    public ProductCatalog(WebDriver driver) {
        super(driver);
    }

    public boolean areProductsDisplayed() {
        return !productList.isEmpty();
    }

    public List<Double> getProductPrices() {
        return productList.stream()
                .map(ProductCatalog::getPriceInDouble)
                .collect(Collectors.toList());
    }

    public void addAllItemsToCart() {
        productList.forEach(ProductCatalog::addToCart);
    }

    public boolean areAddToCartButtonsVisible() {
        return productList.stream().allMatch(ProductCatalog::isAddButtonDisplayed);
    }

    public boolean areRemoveFromCartButtonsVisible() {
        return productList.stream().allMatch(ProductCatalog::isRemoveButtonDisplayed);
    }

    public List<String> getProductNames() {
        List<WebElement> productElements = driver.findElements(By.className("inventory_item_name"));
        List<String> productNames = new ArrayList<>();
        for (WebElement element : productElements) {
            productNames.add(element.getText());
        }
        return productNames;
    }

    public void performSortAction(SortOrder sortOrder) {
        WebElement sortDropdown = driver.findElement(By.className("product_sort_container"));
        Select select = new Select(sortDropdown);
        select.selectByVisibleText(sortOrder.name);
    }

    public boolean sortAndVerify(SortOrder sortOrder) {
        performSortAction(sortOrder);

        List<Double> sortedProductPrices = getProductPrices();

        switch (sortOrder) {
            case PRICE_LOW_TO_HIGH:
                return isSortedAscending(sortedProductPrices);
            case PRICE_HIGH_TO_LOW:
                return isSortedDescending(sortedProductPrices);
            case A_TO_Z:
                List<String> productNames = getProductNames();
                return isSortedAlphabetically(productNames);
            case Z_TO_A:
                productNames = getProductNames();
                return isSortedAlphabeticallyReversed(productNames);
            default:
                return false;
        }
    }

    public boolean isSortedAscending(List<Double> prices) {
        for (int i = 0; i < prices.size() - 1; i++) {
            if (prices.get(i) > prices.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public boolean isSortedDescending(List<Double> prices) {
        for (int i = 0; i < prices.size() - 1; i++) {
            if (prices.get(i) < prices.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public boolean isSortedAlphabetically(List<String> names) {
        for (int i = 0; i < names.size() - 1; i++) {
            if (names.get(i).compareTo(names.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isSortedAlphabeticallyReversed(List<String> names) {
        for (int i = 0; i < names.size() - 1; i++) {
            if (names.get(i).compareTo(names.get(i + 1)) < 0) {
                return false;
            }
        }
        return true;
    }

    public String getItemNameText() {
        return itemNameElement.getText();
    }

    public String getProductName() {
        return productNameText.getText();
    }

    public Double getPriceInDouble() {
        return Double.valueOf(productPriceText.getText().replace("$", ""));
    }

    public void addToCart() {
        addToCartButton.click();
    }

    public void removeFromCart() {
        removeFromCartButton.click();
    }

    public boolean isAddButtonDisplayed() {
        return addToCartButton.isDisplayed();
    }

    public boolean isRemoveButtonDisplayed() {
        return removeFromCartButton.isDisplayed();
    }
}
