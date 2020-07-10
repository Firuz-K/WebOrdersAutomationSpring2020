package com.weborders;

import com.weborders.utilities.ConfigurationReader;
import com.weborders.utilities.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



public abstract class TestBase {

    @BeforeMethod
    public void setUp(){

        String URL = ConfigurationReader.getProperty("url");

        Driver.getDriver().get(URL);

        Driver.getDriver().manage().window().maximize();

    }

    @AfterMethod
    public void teraDown(){

        Driver.closeDriver();

    }




}
