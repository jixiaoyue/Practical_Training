package com.example.uiauto_hwc;

import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiCollection;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiScrollable;
import androidx.test.uiautomator.UiSelector;

import org.junit.Test;

public class ParentsdyTest extends BaseTest {
//    1，家长圈发表文字+图片动态（图片预览使用）
    @Test
    public void test_dy() throws InterruptedException, UiObjectNotFoundException {
        Thread.sleep(3000);
//      家长圈
        mDevice.findObject(By.res("com.example.homeworkcorrect:id/parent_circle")).click();
        Thread.sleep(3000);
//      检测“推荐圈子”字段 滚动到到对应字段
        UiScrollable noteList = new UiScrollable( new UiSelector().scrollable(true));
        UiObject note = null;
        if(noteList.exists()) {
            note = noteList.getChildByText(new UiSelector().className("android.widget.ScrollView"), "推荐圈子", true);
        } else {
            mDevice.findObject(By.res("com.example.homeworkcorrect:id/publish")).click();
        }

        mDevice.findObject(By.res("com.example.homeworkcorrect:id/publish")).click();
        Thread.sleep(3000);
        mDevice.click(521, 134);
        Thread.sleep(3000);
        mDevice.findObject(By.res("com.example.homeworkcorrect:id/ss_edit_content")).setText("uiautomator测试动态");
        Thread.sleep(3000);
//      添加图片
        mDevice.findObject(By.res("com.example.homeworkcorrect:id/main_gridView_item_photo")).click();
//        用collection获取图片集合
        UiCollection collection = new UiCollection(new UiSelector().className("androidx.recyclerview.widget.RecyclerView").instance(0));
//       循环选中前三个图片
        for (int i = 0; i <3; i++) {
            UiSelector rec=new UiSelector().className("android.widget.FrameLayout").index(i);
//            check按钮元素获取
            UiSelector check=new UiSelector().className("android.view.View");
            UiObject object = collection.getChild(rec).getChild(check);
            object.click();
            Thread.sleep(3000);
        }

        mDevice.findObject(By.text("预览")).click();
        Thread.sleep(3000);
        mDevice.findObject(By.res("com.example.homeworkcorrect:id/button_apply")).click();
        Thread.sleep(3000);
        mDevice.findObject(By.res("com.example.homeworkcorrect:id/ss_send")).click();
        Thread.sleep(3000);
    }
//  2，家长圈点赞动态
    @Test
    public void test_give_like() throws InterruptedException {
        mDevice.findObject(By.res("com.example.homeworkcorrect:id/parent_circle")).click();
        Thread.sleep(3000);
//        点赞
        mDevice.findObject(By.res("com.example.homeworkcorrect:id/fre_like_one")).click();
        Thread.sleep(3000);
    }
//    3，家长圈动态点击分享
    @Test
    public void test_give_share() throws InterruptedException {
        mDevice.findObject(By.res("com.example.homeworkcorrect:id/parent_circle")).click();
        Thread.sleep(3000);
//        分享
        mDevice.findObject(By.res("com.example.homeworkcorrect:id/fre_forward")).click();
        Thread.sleep(3000);
    }
//  4，家长圈动态点击评论
    @Test
    public void test_give_comment() throws InterruptedException {
        mDevice.findObject(By.res("com.example.homeworkcorrect:id/parent_circle")).click();
        Thread.sleep(3000);
//        点击评论（评论输入文字功能，开发还未实现）
        mDevice.findObject(By.res("com.example.homeworkcorrect:id/fre_comment")).click();
        Thread.sleep(3000);
//        quit();
    }
//  5，点击第一条朋友圈->查看动态详情->查看图片
    @Test
    public void test_dy_photo() throws UiObjectNotFoundException, InterruptedException {
        mDevice.findObject(By.res("com.example.homeworkcorrect:id/parent_circle")).click();
        Thread.sleep(3000);
        UiCollection collection = new UiCollection(new UiSelector().className("android.widget.ListView").instance(0));
//      根据count值指定被修改
        int count = collection.getChildCount(new UiSelector().className("android.widget.RelativeLayout"));
        System.out.println("count为" + count);
        if (count > 0) {
            UiObject object = collection.getChild(new UiSelector().index(1));
            object.click();
        }

        mDevice.pressBack();
    }

//   6，点击第一条朋友圈的图片（大图预览）
    @Test
    public void test_dys_photo() throws UiObjectNotFoundException, InterruptedException {
        mDevice.findObject(By.res("com.example.homeworkcorrect:id/parent_circle")).click();
        Thread.sleep(3000);
        UiCollection collection = new UiCollection(new UiSelector().resourceId("com.example.homeworkcorrect:id/send_img_list").instance(0));
//      根据count值指定被修改
        int count = collection.getChildCount(new UiSelector().className("android.widget.ImageView"));
        System.out.println("count为" + count);
        if (count > 0) {
            UiObject object = collection.getChild(new UiSelector().index(0));
            object.click();
            Thread.sleep(3000);
        }

        mDevice.pressBack();
    }

}
