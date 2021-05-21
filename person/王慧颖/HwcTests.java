package com.example.uiautomatorapplication;

import android.os.RemoteException;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject2;

import org.junit.Before;
import org.junit.Test;

public class HwcTests {
    UiDevice mDevice;
    @Before
    public void testLogin() throws InterruptedException, RemoteException {
        //获取设备，连接模拟器
        mDevice = UiDevice.getInstance
                (InstrumentationRegistry.
                        getInstrumentation());
        if (mDevice.isScreenOn()) {
            mDevice.wakeUp();
        }
        mDevice.pressHome();
        Thread.sleep(8000);
        UiObject2 Hwc = mDevice.findObject(By.text("作业批家长端"));
        Hwc.click();
        Thread.sleep(3000);
    }
    @Test
    public void test01() throws InterruptedException {
        //测试登录
        //点击我的页面
        mDevice.findObject(By.res("com.example.homeworkcorrect:id/mine")).click();
        Thread.sleep(3000);
        //点击登录
        mDevice.findObject(By.res("com.example.homeworkcorrect:id/login_kip")).click();
        Thread.sleep(3000);
        //账号密码登录
        mDevice.findObject(By.res("com.example.homeworkcorrect:id/tv_login")).click();
        //输入手机号
        Thread.sleep(3000);
        mDevice.findObject(By.res("com.example.homeworkcorrect:id/et_numberwithpassword")).setText("15630137321");
       //输入密码
        mDevice.findObject(By.res("com.example.homeworkcorrect:id/et_password")).setText("123456");
        //登录
        mDevice.findObject(By.res("com.example.homeworkcorrect:id/bt_loginwithpass")).click();
    }
    @Test
    public void test02() throws InterruptedException {
        //测试能否修改昵称
        //点击头像区域
        mDevice.findObject(By.res("com.example.homeworkcorrect:id/image_user")).click();
        Thread.sleep(3000);
        //点击修改昵称
        mDevice.findObject(By.res("com.example.homeworkcorrect:id/change_nickname")).click();
        Thread.sleep(3000);
        mDevice.findObject(By.res("com.example.homeworkcorrect:id/et_nickname")).setText("whywhy");
        mDevice.findObject(By.res("com.example.homeworkcorrect:id/bt_finish")).click();
    }
    @Test
    public void test03() throws InterruptedException {
        //测试能否修改性别
        //点击头像区域
        mDevice.findObject(By.res("com.example.homeworkcorrect:id/image_user")).click();
        Thread.sleep(3000);
        //点击性别
        mDevice.findObject(By.res("com.example.homeworkcorrect:id/change_sex")).click();
        Thread.sleep(3000);
        //女
        mDevice.findObject(By.res("com.example.homeworkcorrect:id/rb_2")).click();
        mDevice.findObject(By.res("com.example.homeworkcorrect:id/bt_finish2")).click();
    }
    @Test
    public void test04() throws InterruptedException {
        //测试能否修改手机号
        //点击头像区域
        mDevice.findObject(By.res("com.example.homeworkcorrect:id/image_user")).click();
        Thread.sleep(3000);
        //点击手机号
        mDevice.findObject(By.res("com.example.homeworkcorrect:id/change_phone")).click();
        //输入新手机号
        mDevice.findObject(By.res("com.example.homeworkcorrect:id/et_phonenumber")).setText("15630137321");
        mDevice.findObject(By.res("com.example.homeworkcorrect:id/bt_finish4")).click();
    }
   }


