package com.weborders.utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class BrowserUtils {

    public static void takeScreenShot(){

        TakesScreenshot takesScreenshot =(TakesScreenshot)Driver.getDriver();
        byte[] screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);

        try {
            String path = System.getProperty("user.dir")+ File.separator+"screenshots"+File.separator+"image.png";
            FileOutputStream file = new FileOutputStream(path);

            file.write(screenshot);
            }catch(IOException e){
            e.printStackTrace();
        }

    }
}
