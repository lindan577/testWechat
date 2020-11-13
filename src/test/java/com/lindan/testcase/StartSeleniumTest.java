package com.lindan.testcase;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author lindan
 * @date 2020-11-10 13:01
 */
public class StartSeleniumTest {

    @Test
    public void startSelenium(){
       // System.setProperty("webdriver.chrome.driver", "/Users/danlin/DevelopmentTestTool/chrome/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.baidu.com");
     //   driver.close();

    }
}
