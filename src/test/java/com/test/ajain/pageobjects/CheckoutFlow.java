package com.test.ajain.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutFlow extends BasePage {

    public static final By checkOut = By.xpath("//div[@id='layer_cart']//a[@title='Proceed to checkout']");
    public static final By checkOutContinue = By.xpath("//div[@id='center_column']//a[@title='Proceed to checkout']");
    public static final By iAgreeCheckBox = By.id("cgv");
    public static final By payByCheck = By.partialLinkText("Pay by check");
    public static final By iConfirmOrder = By.xpath("//button/span[text()[normalize-space() ='I confirm my order']]");
    public static final By buttonProcessAddress = By.name("processAddress"); //processCarrier
    public static final By buttonProcessCarrier = By.name("processCarrier"); //processCarrier
    public static final By orderDetails = By.xpath("//div[@class='box order-confirmation']");
    private static final By backtoOrder = By.linkText("Back to orders");


    public String extractOrderNumber() {
        String orderLine = findElement(By.xpath("//div[@class='box order-confirmation']")).getText().split("\n")[4];
        return orderLine.replace("- Do not forget to include your order reference ","").replace(".","");

    }

//findElement(By.linkText("Back to orders")).click()
    //findElement(By.xpath("//div[@class='box order-confirmation']")).getText().split("\n")[4]
    //- Do not forget to include your order reference bcbcbcb.
//findElement(By.xpath("//table/tbody/tr/td/a")).getText()

    public void clickCheckOut() {
        findElement(checkOut).click();
    }

    public void clickCheckOutAfterSummary() {
        findElement(checkOutContinue).click();
    }

    public void proceedToCheckoitAfterAddress() {
        findElement(buttonProcessAddress).click();
    }
    public void proceedToCheckoitAfterShipping() {
        findElement(buttonProcessCarrier).click();
    }

    public void clickIAgree() {
        findElement(iAgreeCheckBox).click();
    }

    public void paymentByCheck() {
        findElement(payByCheck).click();
    }

    public void clickIConfirmOrder() {
        findElement(iConfirmOrder).click();
        getWait().until(ExpectedConditions.titleIs("Order confirmation - My Store"));
    }

    public void clickBackToOrder(){
        findElement(backtoOrder).click();
        getWait().until(ExpectedConditions.titleIs("Order history - My Store"));
    }

}
