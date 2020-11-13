package com.lindan.testcase;

import com.lindan.comm.BaseTest;
import org.junit.jupiter.api.Test;

/**
 * @author lindan
 * @date 2020-11-11 17:05
 */
public class BrowserTest extends BaseTest {

    @Test
    public  void browertest(){
        driver.get("https://www.baidu.com/");

    }

}
