package com.test.ajain.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShopTshirt extends BasePage{

    //TODO enhancement 2- instead of hard coding product, it can be read from CSV or get it from feature file, data table, example table
    public static final By myTshirt = By.xpath("//div[@class='product-image-container']/a[@title='Faded Short Sleeve T-shirts']");
    public static final By addToCart = By.xpath("//div[@class='button-container']/a[@title='Add to cart']");
    public static final By productAddedMsg = By.xpath("//i[@class='icon-ok']/..");
    public static final By itemInCart = By.xpath("//div[@class='layer_cart_cart col-xs-12 col-md-6']/h2");

    public void clikcMyTshirt(){
        findElement(myTshirt).move();
    }

    public void clickAddToCart(){
        findElement(addToCart).clickable().click();
        getWait().until(ExpectedConditions.textToBe(productAddedMsg,successProductAddMsg));
    }

    public String getItemInCartMsg(){
        return findElement(itemInCart).getText().trim();
    }

}
