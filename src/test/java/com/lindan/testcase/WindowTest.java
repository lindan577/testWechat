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
public class WindowTest {
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
    public   void openWindow(){
        try {
            webDriver.get("https://baidu.com");
            webDriver.manage().window().maximize();
            //$x("//div[@id='u1']//a[@name='tj_login']")
            webDriver.findElement(By.xpath("//div[@id='u1']//a[@name='tj_login']")).click();
            webDriver.findElement(By.xpath("//*[@class='pass-reglink pass-link']")).click();
            Thread.sleep(2000);
            String baiduWin = webDriver.getWindowHandle();
            for(String win :webDriver.getWindowHandles()){
                if(!win.equals(baiduWin)){
                    webDriver.switchTo().window(baiduWin);
                    webDriver.findElement(By.xpath("//*[@class='tang-pass-footerBarULogin pass-link']")).click();
                    webDriver.findElement(By.id("TANGRAM__PSP_11__userName")).sendKeys("ashin");
                    webDriver.findElement(By.id("TANGRAM__PSP_11__password")).sendKeys("18666666666");
                    Thread.sleep(3000);
                    webDriver.findElement(By.id("TANGRAM__PSP_11__submit")).click();


                }
            }


            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    @AfterAll
    public static void  tearDown(){
        webDriver.quit();
    }
}
