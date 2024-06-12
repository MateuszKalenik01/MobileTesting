package com.solvd.pages.common;

import com.solvd.components.MainNavigationMenu;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@Getter
public abstract class AbstactMenuPage extends AbstractPage {
    @FindBy(id = "react-burger-menu-btn")
    private MainNavigationMenu mainMenu;
    public AbstactMenuPage(WebDriver webDriver){
        super(webDriver);
        this.mainMenu=new MainNavigationMenu(webDriver);
    }
}
