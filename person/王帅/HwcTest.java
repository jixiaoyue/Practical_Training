package com.example.ch12application;

import android.os.RemoteException;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject2;

import org.junit.Before;
import org.junit.Test;

public class HwcTest {
    UiDevice mDevice;
    @Before
    public void testLogin() throws InterruptedException, RemoteException {
        //获取设备，连接模拟器
        mDevice=UiDevice.getInstance
                (InstrumentationRegistry.
                        getInstrumentation());
        if(mDevice.isScreenOn()){
            mDevice.wakeUp();
        }
        mDevice.pressHome();Thread.sleep(8000);
        UiObject2 Hwc=mDevice.findObject(By.text("作业批家长端"));
        Hwc.click();
        Thread.sleep(3000);

        mDevice.findObject(By.res
                ("com.example.homeworkcorrect:id/mine"))
                .click();
        Thread.sleep(3000);
        mDevice.findObject(By.res
                ("com.example.homeworkcorrect:id/login_kip"))
                .click();
        Thread.sleep(3000);
        mDevice.findObject(By.res
                ("com.example.homeworkcorrect:id/tv_login"))
                .click();
        Thread.sleep(3000);
        mDevice.findObject(By.res
                ("com.example.homeworkcorrect:id/et_numberwithpassword"))
                .setText("15128985756");
        mDevice.findObject(By.res
                ("com.example.homeworkcorrect:id/et_password"))
                .setText("123456");
        mDevice.findObject(By.res
                ("com.example.homeworkcorrect:id/bt_loginwithpass"))
                .click();
    }
//    @Test
//    public void testlogin() throws InterruptedException {
//        mDevice.findObject(By.res
//                ("com.example.homeworkcorrect:id/mine"))
//                .click();
//        Thread.sleep(3000);
//        mDevice.findObject(By.res
//                ("com.example.homeworkcorrect:id/login_kip"))
//                .click();
//        Thread.sleep(3000);
//        mDevice.findObject(By.res
//                ("com.example.homeworkcorrect:id/tv_login"))
//                .click();
//        Thread.sleep(3000);
//        mDevice.findObject(By.res
//                ("com.example.homeworkcorrect:id/et_numberwithpassword"))
//                .setText("15128985756");
//        mDevice.findObject(By.res
//                ("com.example.homeworkcorrect:id/et_password"))
//                .setText("123456");
//        mDevice.findObject(By.res
//                ("com.example.homeworkcorrect:id/bt_loginwithpass"))
//                .click();
//    }
//
//    @Test
//    public void testphotoAlbum1DeleteSubmit() throws InterruptedException {
//        Thread.sleep(3000);
//        mDevice.findObject(By.res
//                ("com.example.homeworkcorrect:id/main"))
//                .click();
//        Thread.sleep(3000);
//        mDevice.findObject(By.res
//                ("com.example.homeworkcorrect:id/iv_camera"))
//                .click();
//        Thread.sleep(3000);
//        mDevice.findObject(By.res
//                ("com.example.homeworkcorrect:id/choosePicture"))
//                .click();
//        Thread.sleep(3000);
//        mDevice.findObject(By.res
//                ("com.example.homeworkcorrect:id/media_thumbnail"))
//                .click();
//        Thread.sleep(3000);
//        mDevice.findObject(By.res
//                ("com.example.homeworkcorrect:id/check_view"))
//                .click();
//        mDevice.findObject(By.res
//                ("com.example.homeworkcorrect:id/button_apply"))
//                .click();
//        Thread.sleep(3000);
//        mDevice.findObject(By.res
//                ("com.example.homeworkcorrect:id/next"))
//                .click();
//        Thread.sleep(3000);
//        mDevice.findObject(By.res
//                ("com.example.homeworkcorrect:id/main_gridView_item_cb"))
//                .click();
//        mDevice.findObject(By.res
//                ("com.example.homeworkcorrect:id/btn_submit"))
//                .click();
//        Thread.sleep(3000);
//        mDevice.findObject(By.res
//                ("com.example.homeworkcorrect:id/dialog_button"))
//                .click();
//        }
    @Test
    public void viewMessagetest() throws InterruptedException {
        Thread.sleep(3000);
        mDevice.findObject(By.res
                ("com.example.homeworkcorrect:id/iv_ring"))
                .click();
        Thread.sleep(3000);
        mDevice.findObject(By.res
                ("com.example.homeworkcorrect:id/rc_left"))
                .click();
        Thread.sleep(3000);
        mDevice.findObject(By.res
                ("com.example.homeworkcorrect:id/rc_edit_text"))
                .setText("老师辛苦了，谢谢您");
        mDevice.findObject(By.res
                ("com.example.homeworkcorrect:id/rc_send_toggle"))
                .click();
        mDevice.findObject(By.res
                ("com.example.homeworkcorrect:id/return_msg"))
                .click();
        Thread.sleep(3000);
        mDevice.findObject(By.res
                ("com.example.homeworkcorrect:id/return_list"))
                .click();

    }

}
