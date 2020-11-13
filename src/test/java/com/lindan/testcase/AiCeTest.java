package com.lindan.testcase;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
 import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * @author lindan
 * @date 2020-11-10 17:15
 */
public class AiCeTest {

    /*1、打开页面
    2、点击登录
    3、输入用户名和密码
    4、确认登录*/
   public static WebDriver webDriver;
   public static WebDriverWait webDriverWait;

        @BeforeAll
        public static void  initData(){
            webDriver = new ChromeDriver();
            //显示等待
            //设置某一个
            webDriverWait = new WebDriverWait(webDriver,2);

            //隐式子等待
           // 全局的
            // webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS)
         }

    @Test
    public  void  login(){
        webDriver.get("https://ceshiren.com/");
        webDriver.findElement(By.xpath("//span[contains(text(),'登录')]")).click();
        webDriver.findElement(By.id("login-account-name")).clear();
        webDriver.findElement(By.id("login-account-name")).sendKeys("492320577@qq.com");
        webDriver.findElement(By.id("login-account-password")).clear();
        webDriver.findElement(By.id("login-account-password")).sendKeys("lindan0703");
        webDriver.findElement(By.id("login-button")).click();
    }

    /**
     * 直接等待-用于调试阶段
     * 不推荐使用
     */
    @Test
    public static void  timesleepTest(){
        webDriver.get("https://ceshiren.com/");
        try {
            Thread.sleep(5000);
            webDriver.findElement(By.xpath("//span[contains(text(),'登录')]")).click();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 显式等待
     * 当条件发生时才继续执行代码
     * webDriverWait 配合 until()方法，根据判断条件进行等待
     */
    @Test
    public  void  waitTest(){
        webDriver.get("https://ceshiren.com/");
        /*
        //定制化操作
        WebElement lingEmt =   webDriverWait.until(
                    new ExpectedCondition<WebElement>() {
                        public WebElement apply(WebDriver driver){
                            return driver.findElement(By.xpath("//span[contains(text(),'登录')]"));
                        }
                    }

            );*/
          Boolean until =  webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[contains(text(),'登录')]")));
          WebElement until2 =  webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'登录')]")));



    }


    @AfterAll
    public static void  tearDown(){
        webDriver.quit();
    }


}
