package com.example.uiauto_hwc;

import androidx.test.uiautomator.By;

import org.junit.Test;

public class ParentsdyTest extends BaseTest{

    //打开进行中
    @Test
    public void test1(){
        mDevice.findObject(By.text("进行中")).click();
    }
    //打开已完成
    @Test
    public void test2(){
        mDevice.findObject(By.text("已完成")).click();
    }
    //打开我的钱包
    @Test
    public void test3(){
        mDevice.findObject(By.text("我的钱包")).click();
    }
    //打开设置
    @Test
    public void test4(){
        mDevice.findObject(By.text("设置")).click();
    }
    //打开联系我们
    @Test
    public void test5(){
        mDevice.findObject(By.text("联系我们")).click();
    }
}
