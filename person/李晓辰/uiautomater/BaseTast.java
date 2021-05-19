package com.example.ch12;

import android.os.RemoteException;
import android.util.Log;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject2;

import org.junit.Before;

public class BaseTast {
    public static UiDevice mDevice;

//    public void quit() throws InterruptedException {
//        Thread.sleep(3000);
//        mDevice.findObject(By.res("com.example.homeworkcorrect:id/setting_relative")).click();
//        Thread.sleep(3000);
//        mDevice.findObject(By.res("com.example.homeworkcorrect:id/logoff")).click();
//        Thread.sleep(3000);
//    }

    public void login() throws InterruptedException {
        mDevice.findObject(By.res("com.example.homeworkcorrectteacher:id/login_kip")).click();
        Thread.sleep(3000);
        mDevice.findObject(By.res("com.example.homeworkcorrectteacher:id/tv_login")).click();
        Thread.sleep(3000);
        mDevice.findObject(By.res("com.example.homeworkcorrectteacher:id/et_numberwithpassword")).setText("18732627309");
        mDevice.findObject(By.res("com.example.homeworkcorrectteacher:id/et_password")).setText("123456");
        Thread.sleep(3000);
        mDevice.findObject(By.res("com.example.homeworkcorrectteacher:id/bt_loginwithpass")).click();
    }

    @Before
    public void testLogin() throws RemoteException, InterruptedException{
        //获取设备，连接模拟器
        mDevice = UiDevice.getInstance
                (InstrumentationRegistry.getInstrumentation());
        if (mDevice.isScreenOn()) {
            mDevice.wakeUp();
        }
        //回到主页
        int width = mDevice.getDisplayWidth();
        int height = mDevice.getDisplayHeight();
        mDevice.pressHome();
        Thread.sleep(2000);
        mDevice.swipe(width-10,height/2,50,height/2,10);
        Thread.sleep(2000);
        //获取APP名
        UiObject2 todolist1 = mDevice.findObject(By.text("编辑图片"));
        todolist1.click();
        Thread.sleep(3000);

    /*
       判断当前状态是不是已经登录，如果是，quit(),
                login
                        */
        mDevice.findObject(By.res("com.example.homeworkcorrectteacher:id/mine")).click();
        UiObject2 x = mDevice.findObject(By.text("点击登录"));
        if (x != null) {
            Log.i("login", "未登录");
            login();
        }
//        else {
//            Log.i("login", "已经登录");
//            quit();
//        }

    }
}
