package com.lindan.homework;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author lindan
 * @date 2020-11-13 21:35
 */
public class MyHomeWork {
   public static Actions actions ;
    WebDriver driver ;

    /**
     * 登录
     * @throws IOException
     * @throws InterruptedException
     */
    @Test
    public void testLogin() throws IOException, InterruptedException {
         driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://work.weixin.qq.com/wework_admin/frame");
        //sleep 20
        Thread.sleep(15000);
        Set<Cookie> cookies = driver.manage().getCookies();
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.writeValue(new File("cookies.yaml"), cookies);
    }

    /**
     * 通过cookie 跳过扫描登录
     * @throws IOException
     * @throws InterruptedException
     */
    @Test
    public void testLogined() throws IOException, InterruptedException {
        driver = new ChromeDriver();
       // driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://work.weixin.qq.com/wework_admin/frame");

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        TypeReference typeReference=new TypeReference<List<HashMap<String, Object>>>() {};
        List<HashMap<String, Object>> cookies = mapper.readValue(new File("cookies.yaml"), typeReference);
        System.out.println(cookies);

        cookies.forEach(cookieMap->{
            driver.manage().addCookie(new Cookie(cookieMap.get("name").toString(), cookieMap.get("value").toString()));
        });

      //  driver.navigate().refresh();
    }

    /**
     * 添加成员
     */
    @Test
    public void addMembers(){

        driver = new ChromeDriver();
        driver.get("https://work.weixin.qq.com/wework_admin/frame#contacts");

        Map<String ,String > map = new HashMap<>();
        map.put("username","lindan2");
        driver.findElement(By.xpath("//span[text()='添加成员']")).click();
         /* driver.findElement(By.xpath("//input[@id='username']")).sendKeys(map.get("username"));
         driver.findElement(By.xpath("//input[@id='memberAdd_english_name']")).sendKeys(map.get("memberAdd_english_name"));
         driver.findElement(By.xpath("//input[@id='memberAdd_acctid']")).sendKeys(map.get("memberAdd_acctid"));
         driver.findElement(By.xpath("//input[@id='memberAdd_phone']")).sendKeys(map.get("18515502212"));
         driver.findElement(By.xpath("//input[@id='memberAdd_title']")).sendKeys(map.get("memberAdd_title"));
         driver.findElement(By.xpath("//a[contains(text(),'保存')]")).click();*/


        //1、找到添加成员按钮，点击
        //输入框中设置内容
        //点击保存
        //点击保存并添加 循环输入内容



    }


}
