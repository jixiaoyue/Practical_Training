package com.example.uiauto_hwc;

import android.os.RemoteException;
import android.util.Log;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject2;
import androidx.test.uiautomator.UiObjectNotFoundException;

import org.junit.Before;

public class BaseTest {
    UiDevice mDevice;
    public void login() throws InterruptedException {
//        mDevice.findObject(By.res("com.example.homeworkcorrect:id/mine")).click();
        mDevice.findObject(By.res("com.example.homeworkcorrectteacher:id/mine_text")).click();
        Thread.sleep(3000);
        mDevice.findObject(By.res("com.example.homeworkcorrectteacher:id/login_kip")).click();
        Thread.sleep(3000);
        mDevice.findObject(By.res("com.example.homeworkcorrectteacher:id/tv_login")).click();
        Thread.sleep(3000);
        mDevice.findObject(By.res("com.example.homeworkcorrectteacher:id/et_numberwithpassword")).setText("15533676833");
        mDevice.findObject(By.res("com.example.homeworkcorrectteacher:id/et_password")).setText("123456");
        Thread.sleep(3000);
        mDevice.findObject(By.res("com.example.homeworkcorrectteacher:id/bt_loginwithpass")).click();

    }
    @Before
    public void testLogin() throws InterruptedException, RemoteException, UiObjectNotFoundException {
//      获取设备，连接模拟器
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        if (mDevice.isScreenOn()) {
            mDevice.wakeUp();

        }
//      回到主页
        mDevice.pressHome();
        int width = mDevice.getDisplayWidth();
        int height = mDevice.getDisplayHeight();
        Log.w("Width:", String.valueOf(width));
        Log.w("Height:", height + "");
//      mDevice.click(1066,271);
        Thread.sleep(8000);
//      滑动

//      获取APP名
        UiObject2 hwcParents = mDevice.findObject(By.text("编辑图片"));
        hwcParents.click();
        Thread.sleep(3000);

/*
判断当前状态是不是已经登录，如果是，quit(),
login
 */
        mDevice.findObject(By.res("com.example.homeworkcorrectteacher:id/mine_text")).click();
        UiObject2 x = mDevice.findObject(By.text("点击登录"));
        if (x != null) {
            Log.i("login", "未登录");
            login();
        } else {
            Log.i("login", "已经登录");
        }
    }
}
