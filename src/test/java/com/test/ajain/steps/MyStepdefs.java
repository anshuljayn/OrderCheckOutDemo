package com.test.ajain.steps;

import automation.library.common.Property;
import automation.library.cucumber.core.Constants;
import automation.library.cucumber.selenium.BaseSteps;
import automation.library.reporting.Reporter;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import com.test.ajain.pageobjects.*;

public class MyStepdefs extends BaseSteps {

    public String placedOrder;
    private MyPersonalInfo myPersonalInfo;
    public String user;

    @And("I login with valid credential {string}")
    public void iLoginWithValidCredential(String arg0) {
        user = arg0;
        String email = Property.getProperty(Constants.ENVIRONMENTPATH + Property.getVariable("cukes.env") + ".properties", arg0 + "_email");
        String pass = Property.getProperty(Constants.ENVIRONMENTPATH + Property.getVariable("cukes.env") + ".properties", arg0 + "_pwd");

        Login login = new Login();
        login.login(email, pass);
        Assert.assertEquals(login.getH1(), "MY ACCOUNT", "not on My account page");
    }

    @When("I add T-shirt to cart")
    public void iAddTShirtToCart() {

        MenuBar menuBar = new MenuBar();
        menuBar.clickTShirt();
        Assert.assertEquals(menuBar.getTitle(), "T-shirts - My Store", "not on T-Shirt page");

        //TODO enhancement 1: if t-shirt parameter is passed from feature then reflection can be used to get the righ POM
        ShopTshirt shopTshirt = new ShopTshirt();
        shopTshirt.clikcMyTshirt();

        shopTshirt.clickAddToCart();
        //TODO enhancement 3- Advance assertion - check how many item in cart before adding the t-shirt then add one
        // and then assert the statement
        Assert.assertTrue(shopTshirt.getItemInCartMsg().startsWith("There"));
        Assert.assertTrue(shopTshirt.getItemInCartMsg().endsWith("in your cart."));
    }

    @And("I checkout")
    public void iCheckout() {
        CheckoutFlow checkoutFlow = new CheckoutFlow();
        checkoutFlow.clickCheckOut();
        Assert.assertEquals(checkoutFlow.getTitle(), "Order - My Store", "not on Order - My Store page");

        checkoutFlow.clickCheckOutAfterSummary();
        Assert.assertEquals(checkoutFlow.getH1(), "ADDRESSES");

        checkoutFlow.proceedToCheckoitAfterAddress();
        Assert.assertEquals(checkoutFlow.getH1(), "SHIPPING");

        checkoutFlow.clickIAgree();
        checkoutFlow.proceedToCheckoitAfterShipping();
        Assert.assertEquals(checkoutFlow.getH1(), "PLEASE CHOOSE YOUR PAYMENT METHOD");

        checkoutFlow.paymentByCheck();
        Assert.assertEquals(checkoutFlow.getH1(), "ORDER SUMMARY");

        checkoutFlow.clickIConfirmOrder();
        Assert.assertEquals(checkoutFlow.getH1(), "ORDER CONFIRMATION");

        placedOrder = checkoutFlow.extractOrderNumber();
        System.out.println("placed order: " + placedOrder);
        Reporter.addStepLog("placed order: " + placedOrder);

        checkoutFlow.clickBackToOrder();
    }

    @And("I have order in order history")
    public void iHaveOrderInOrderHistory() {
        OrderHistory orderHistory = new OrderHistory();
        Assert.assertEquals(orderHistory.getH1(),"ORDER HISTORY");
        Assert.assertEquals(orderHistory.getLatestOrderNumber(), placedOrder, "order number is not correct");

        //TODO enhancement 4: further more assertion date, amount etc.
    }


    @When("I update my firstname to {string}")
    public void iUpdateMyFirstnameTo(String arg0) {
        MyAccount myAccount = new MyAccount();
        myPersonalInfo = myAccount.clickMyPersonalInfo();

        String pass = Property.getProperty(Constants.ENVIRONMENTPATH + Property.getVariable("cukes.env") + ".properties", user + "_pwd");
        myPersonalInfo.updateFName(arg0,pass);
    }

    @Then("I received success Alert message {string}")
    public void iReceivedSuccessAlertMessage(String arg0) {
        Assert.assertEquals(myPersonalInfo.getSuccessAlert(),arg0);
    }

    @And("display name updated to have {string}")
    public void displayNameUpdatedToHave(String arg0) {
        Assert.assertTrue(myPersonalInfo.getDisplayName().toLowerCase().contains(arg0.toLowerCase()));
        //TODO enhancement 5 - if there is DB connectivity then it can be checked for validation as well
    }
}
