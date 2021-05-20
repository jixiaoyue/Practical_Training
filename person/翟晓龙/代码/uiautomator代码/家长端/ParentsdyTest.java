package com.example.uiauto_hwc;

import androidx.test.uiautomator.By;

import org.junit.Test;

public class ParentsdyTest extends BaseTest{

    //打开商品
    @Test
    public void test1() throws InterruptedException {
        Thread.sleep(3000);
        mDevice.findObject(By.res("com.example.homeworkcorrect:id/shop_text")).click();
        mDevice.findObject(By.res("com.example.homeworkcorrect:id/commodity_name")).click();
    }

    //搜索
    @Test
    public void test2() throws InterruptedException {
        Thread.sleep(3000);
        mDevice.findObject(By.res("com.example.homeworkcorrect:id/shop_text")).click();
        mDevice.findObject(By.res("com.example.homeworkcorrect:id/search_tv_search")).setText("demo");
    }
}
