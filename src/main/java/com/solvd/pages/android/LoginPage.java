package com.solvd.pages.android;

import com.solvd.pages.common.LoginBasePage;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE,parentClass = LoginBasePage.class)
public class LoginPage extends LoginBasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }
}
