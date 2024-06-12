package com.solvd.pages.common;

import com.solvd.components.MainNavigationMenu;
import com.solvd.components.ProductCatalog;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@Getter
public abstract class AbstractCatalogMenuPage extends AbstactMenuPage {
    @FindBy(xpath = ".//*[@class = 'inventory_item_name']")
    private ProductCatalog productCatalog;
    public AbstractCatalogMenuPage(WebDriver webDriver){
        super(webDriver);
        this.productCatalog=new ProductCatalog(webDriver);
    }
}