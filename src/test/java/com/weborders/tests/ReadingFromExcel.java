package com.weborders.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;

import com.weborders.utilities.ExcelUtil;
import com.weborders.utilities.ExcelUtil;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;

public class ReadingFromExcel {

    WebDriver driver;


    @Test()
    public void readingFromExcel() {


        try (FileInputStream fileInputStream = new FileInputStream("VytrackTestUsers.xlsx")) {
            Workbook workbook = WorkbookFactory.create(fileInputStream);

            Sheet sheet = workbook.getSheet("QA1-all");

            Row row = sheet.getRow(1);
            Cell cell = row.getCell(1);
            System.out.println(cell);

            int columnCount = row.getPhysicalNumberOfCells();

            for (int i = 0; i < columnCount; i++) {
                System.out.print(row.getCell(i) + " ");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Test(dataProvider = "testData")
    public void readingData(String execute,String username, String password, String firstname,String lastname, String result) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(true);
        driver = new ChromeDriver(chromeOptions);

        driver.get("https://qa1.vytrack.com/user/login");
        driver.findElement(By.xpath("//input[@id='prependedInput']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='prependedInput2']")).sendKeys(password + Keys.ENTER);

        Thread.sleep(3000);


        Assert.assertEquals(driver.getTitle(), "Dashboard");

    }

    @DataProvider
    public Object[][] testData() {
        ExcelUtil excelUtil = new ExcelUtil("VytrackTestUsers.xlsx", "QA2-short");
        return excelUtil.getDataArray();
    }


    @AfterMethod
    public void close() {
        if (driver != null) {
            driver.quit();
        }

    }
}


