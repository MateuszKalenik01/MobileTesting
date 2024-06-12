package com.solvd.pages.desktop;

import com.solvd.pages.common.CheckoutDetailsBasePage;
import com.solvd.pages.common.OrderSummaryBasePage;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
@DeviceType(pageType = DeviceType.Type.DESKTOP,parentClass = OrderSummaryBasePage.class)
public class OrdedSummarPage extends OrderSummaryBasePage {
    public OrdedSummarPage(WebDriver driver) {
        super(driver);
    }
}
