package com.test.ajain.pageobjects;

import automation.library.selenium.exec.BasePO;
import org.openqa.selenium.By;

public class BasePage extends BasePO {

    //using BaseClass as static message holder which could be common across different products like T-shirt - Dresses etc.


    public static final String successProductAddMsg = "Product successfully added to your shopping cart";

    public String getTitle(){
        return getDriver().getTitle();
    }


    public String getH1() { return getDriver().findElement(By.tagName("h1")).getText();    }
}
