package com.lindan.comm;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
 import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author lindan
 * @date 2020-11-11 17:05
 */
public class BaseTest {

    public  static   WebDriver driver ;

    @BeforeAll
    public static void initBrowser(){

        String browsername = System.getenv("browser");
        System.out.println("browsername="+browsername);
        driver = new ChromeDriver();

        if("chrome".equals(browsername)){
             driver = new ChromeDriver();
        }/*else if("firefox".equals(browsername)){
            driver = new FirefoxDriver();
        }if("safari".equals(browsername)){
            driver = new SafariDriver();
        }*/

    }

    @AfterAll
    public static void  tearDown(){
        driver.quit();
    }
}
