package com.solvd.desktop;

import com.solvd.BaseTest;
import com.zebrunner.carina.utils.R;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class WebTest extends BaseTest {
    @Parameters({"browser"})
    @BeforeClass
    public void setUp(String browser) {
        R.CONFIG.put("capabilities.browserName", browser);
    }

    @AfterClass
    public void tearDown() {
        if (getDriver() != null) {
            getDriver().quit();
        }
    }
}