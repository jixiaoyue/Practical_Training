package com.example.ch12;

import android.util.Log;

import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;

import org.junit.Test;

public class RewardTest extends BaseTast{

    //验证能否查看悬赏内容
    @Test
    public void test01() throws InterruptedException {
        Thread.sleep(3000);
        this.mDevice.findObject(By.res("com.example.homeworkcorrectteacher:id/main")).click();
        Thread.sleep(2000);
        this.mDevice.findObject(By.clazz("android.widget.Button")).click();
        Thread.sleep(2000);
        this.mDevice.findObject(By.res("com.example.homeworkcorrectteacher:id/img_homework111")).click();
        Thread.sleep(2000);
        this.mDevice.pressBack();
        this.mDevice.pressBack();
    }

    //验证能否切换不同学科的悬赏
    @Test
    public void test02() throws InterruptedException{
        int width = this.mDevice.getDisplayWidth();
        int height = this.mDevice.getDisplayHeight();
        Thread.sleep(3000);
        this.mDevice.findObject(By.res("com.example.homeworkcorrectteacher:id/main")).click();
        Thread.sleep(2000);
        this.mDevice.findObject(By.res("com.example.homeworkcorrectteacher:id/english")).click();
        mDevice.swipe(width/2,50,width/2,height-10,10);
        Thread.sleep(2000);
        this.mDevice.findObject(By.res("com.example.homeworkcorrectteacher:id/math")).click();
        Thread.sleep(2000);
        mDevice.swipe(width-10,height/2,50,height/2,10);
        Thread.sleep(2000);
        mDevice.swipe(50,height/2,width-10,height/2,10);
        Thread.sleep(2000);
        mDevice.swipe(width/2,50,width/2,height-10,10);
    }

    //验证能否接单
    @Test
    public void test03() throws InterruptedException{
        int width = this.mDevice.getDisplayWidth();
        int height = this.mDevice.getDisplayHeight();
        Thread.sleep(3000);
        this.mDevice.findObject(By.res("com.example.homeworkcorrectteacher:id/main")).click();
        Thread.sleep(2000);
        this.mDevice.findObject(By.clazz("android.widget.Button")).click();
        Thread.sleep(2000);
        mDevice.swipe(width/2,height-10,width/2,50,10);
        Thread.sleep(2000);
        this.mDevice.findObject(By.res("com.example.homeworkcorrectteacher:id/checkdetail")).click();
        Thread.sleep(2000);
        this.mDevice.findObject(By.res("com.example.homeworkcorrectteacher:id/positiveTextView")).click();
        Thread.sleep(2000);
        this.mDevice.findObject(By.res("com.example.homeworkcorrectteacher:id/positiveTextView")).click();
        this.mDevice.pressBack();
    }
    //验证能否发送文字消息
    @Test
    public void test04() throws InterruptedException{
        Thread.sleep(3000);
        this.mDevice.findObject(By.res("com.example.homeworkcorrectteacher:id/main")).click();
        Thread.sleep(3000);
        this.mDevice.findObject(By.res("com.example.homeworkcorrectteacher:id/iv_ring")).click();
        Thread.sleep(3000);
        this.mDevice.findObject(By.res("com.example.homeworkcorrectteacher:id/rc_conversation_title")).click();
        Thread.sleep(3000);
        this.mDevice.findObject(By.res("com.example.homeworkcorrectteacher:id/rc_edit_text")).setText("发送文字");
        Thread.sleep(3000);
        this.mDevice.findObject(By.res("com.example.homeworkcorrectteacher:id/rc_send_toggle")).click();
        this.mDevice.pressBack();
        this.mDevice.pressBack();
    }
//验证能否删除消息
    @Test
    public void test05() throws InterruptedException{
        Thread.sleep(3000);
        this.mDevice.findObject(By.res("com.example.homeworkcorrectteacher:id/main")).click();
        Thread.sleep(3000);
        this.mDevice.findObject(By.res("com.example.homeworkcorrectteacher:id/iv_ring")).click();
        Thread.sleep(3000);
        this.mDevice.findObject(By.res("com.example.homeworkcorrectteacher:id/rc_conversation_title")).click();
        Thread.sleep(3000);
        this.mDevice.findObject(By.res("com.example.homeworkcorrectteacher:id/rc_edit_text")).setText("删除消息");
        Thread.sleep(3000);
        this.mDevice.findObject(By.text("删除消息")).longClick();
        Thread.sleep(3000);
        this.mDevice.findObject(By.text("删除消息")).click();
        this.mDevice.pressBack();
        this.mDevice.pressBack();
    }

    //验证好友列表中的好友能否置顶
    @Test
    public void test06() throws InterruptedException{
        Thread.sleep(3000);
        this.mDevice.findObject(By.res("com.example.homeworkcorrectteacher:id/main")).click();
        Thread.sleep(3000);
        this.mDevice.findObject(By.res("com.example.homeworkcorrectteacher:id/iv_ring")).click();
        Thread.sleep(3000);
        this.mDevice.findObject(By.res("com.example.homeworkcorrectteacher:id/rc_conversation_title")).longClick();
        Thread.sleep(3000);
        this.mDevice.findObject(By.text("置顶该会话")).click();
        this.mDevice.pressBack();
        this.mDevice.pressBack();
    }
}
