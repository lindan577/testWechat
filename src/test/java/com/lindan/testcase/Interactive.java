package com.lindan.testcase;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * @author lindan
 * @date 2020-11-11 10:52
 */
public class Interactive {
    public static WebDriver webDriver;
    public static WebDriverWait webDriverWait;
    public static Actions  actions;

    @BeforeAll
    public static void  initData(){
        webDriver = new ChromeDriver();
        //隐式子等待
        // 全局的
         webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }


    @Test
    public   void clickTest(){
         try {
             webDriver.get("http://sahitest.com/demo/clicks.htm");
               actions = new Actions(webDriver);
             //  /html/body/form/input[3]
             actions.click(webDriver.findElement(By.xpath("//html//body//form//input[@value='click me']")));
             actions.doubleClick(webDriver.findElement(By.xpath("//input[@value='dbl click me']")));
             actions.perform();
             Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public   void moveTest(){
        try {
            webDriver.get("https://baidu.com");
            actions = new Actions(webDriver);
             actions.moveToElement(webDriver.findElement(By.id("s-usersetting-top")));
            actions.perform();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    @AfterAll
    public static void  tearDown(){
        webDriver.quit();
    }
}
