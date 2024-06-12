package com.solvd.pages.common;

import com.solvd.components.MainNavigationMenu;
import com.solvd.components.ProductCatalog;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
@Getter
public class ProductListBasePage extends AbstractCatalogMenuPage {
    @FindBy(xpath = "//*[@class = 'primary_header']")
    private MainNavigationMenu mainNavigationMenu;
    @FindBy(xpath = "//*[@class = 'inventory_container']")
    private ProductCatalog productCatalog;

    public ProductListBasePage(WebDriver driver) {
        super(driver);
    }
}
