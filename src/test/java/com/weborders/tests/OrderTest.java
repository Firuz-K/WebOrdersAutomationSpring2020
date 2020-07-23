package com.weborders.tests;

import com.weborders.pages.LoginPage;
import com.weborders.pages.OrderPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrderTest extends TestBase {

    @Test(description = "create random order")
    public void createOrder() throws InterruptedException {

        LoginPage loginPage = new LoginPage();
        OrderPage orderPage = new OrderPage();

        loginPage.login();
        orderPage.ClickOnOrder();

        orderPage.selectProduct("ScreenSaver");
        orderPage.enterQuantity("12");
        orderPage.enterPricePerUnit("20");
        orderPage.enterDiscount("10");
        orderPage.clickToCalculate();

        Assert.assertEquals(orderPage.getTotal(),"216","Total is not matching");
        orderPage.enterCustomerName("Tester User");
        orderPage.enterStreet("5th ave");
        orderPage.enterCity("New York");
        orderPage.enterState("NY");
        orderPage.enterZip("10011");

        // card payment information

        orderPage.selectCard("Visa");
        orderPage.enterCardNumber("12345678343");
        orderPage.enterExpirationDate("04/25");

        orderPage.clickOnProcessButton();
        orderPage.clickOnViewAllOrders();
        Thread.sleep(4000);






    }


}
