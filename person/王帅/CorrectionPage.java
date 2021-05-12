package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.BaseAction;

public class CorrectionPage {
	AndroidDriver<AndroidElement> driver;
	BaseAction action;
//	通过构造方法对于driver初始化；
	public CorrectionPage(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
		this.action= new BaseAction(driver);
	}
	
	public AndroidElement btn_correct() {
		return driver.findElementById("com.example.homeworkcorrect:id/main_img");
	}
	
	public AndroidElement btn_camera() {
		return driver.findElementById("com.example.homeworkcorrect:id/iv_camera");
	}
	
	public AndroidElement btn_takePhoto() {
		return driver.findElementById("com.example.homeworkcorrect:id/takephoto");
	}
	
	public AndroidElement btn_PhotoAlbum() {
		return driver.findElementById("com.example.homeworkcorrect:id/choosePicture");
	}
	
	public AndroidElement selectPhoto(int i) {
		return driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout["+i+"]/android.view.View");
	}
	
	public AndroidElement btn_Photo(int i) {
		return driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout["+i+"]/android.widget.ImageView");
	}
	
	public AndroidElement btn_apply() {
		return driver.findElementById("com.example.homeworkcorrect:id/button_apply");
	}
	
	public AndroidElement btn_forword() {
		return driver.findElementByAccessibilityId("转到上一层级");
	}
	
	public AndroidElement btn_next() {
		return driver.findElementById("com.example.homeworkcorrect:id/next");
	}
	
	public AndroidElement btn_submit() {
		return driver.findElementById("com.example.homeworkcorrect:id/btn_submit");
	}
	
	public AndroidElement btn_ok() {
		return driver.findElementById("com.example.homeworkcorrect:id/dialog_button");
	}
	
	public AndroidElement btn_delete() {
		return driver.findElementById("com.example.homeworkcorrect:id/main_gridView_item_cb");
	}
	
	public AndroidElement btn_deleteSome() {
		return driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.GridView/android.widget.RelativeLayout[2]/android.widget.CheckBox");
	}
	
	public AndroidElement btn_ring() {
		return driver.findElementById("com.example.homeworkcorrect:id/iv_ring");
	}
	
	public AndroidElement btn_ringi(int i) {
		return driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout["+i+"]/android.widget.FrameLayout[1]/android.widget.ImageView");
	}
	
	public AndroidElement edit_replyMessage() {
		return driver.findElementById("com.example.homeworkcorrect:id/rc_edit_text");
	}
	
	public AndroidElement btn_send() {
		return driver.findElementById("com.example.homeworkcorrect:id/rc_send_toggle");
	}
	
	public AndroidElement btn_return() {
		return driver.findElementById("com.example.homeworkcorrect:id/return_msg");
	}
	
	public AndroidElement btn_topMessage() {
		return driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.LinearLayout[1]");
	}
	
	public AndroidElement btn_deleteMessage() {
		return driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.LinearLayout[2]");
	}
	
	public ParentsListPage photoAlbum1Submit(int i) {
		action.click(btn_correct());
		action.click(btn_camera());
		action.click(btn_PhotoAlbum());
		action.click(selectPhoto(i));
		action.click(btn_apply());
		action.click(btn_next());
		action.click(btn_submit());
		action.click(btn_ok());
		return new ParentsListPage(driver);
	
	}
	
	
	public ParentsListPage photoAlbum0Submit() {
		action.click(btn_correct());
		action.click(btn_camera());
		action.click(btn_PhotoAlbum());
		action.click(btn_forword());
		action.click(btn_next());
		action.click(btn_ok());
		return new ParentsListPage(driver);
	
	}
	
	
	public ParentsListPage photoAlbumsSubmit(int i,int j) {
		action.click(btn_correct());
		action.click(btn_camera());
		action.click(btn_PhotoAlbum());
		for(int m=j;m<=i+j;m++) {
			action.click(selectPhoto(m));
		}
		action.click(btn_apply());
		action.click(btn_next());
		action.click(btn_submit());
		action.click(btn_ok());
		return new ParentsListPage(driver);
	
	}
	
	public ParentsListPage photoAlbum1DeleteSubmit(int i) {
		action.click(btn_correct());
		action.click(btn_camera());
		action.click(btn_PhotoAlbum());
		action.click(selectPhoto(i));
		action.click(btn_apply());
		action.click(btn_next());
		action.click(btn_delete());
		action.click(btn_submit());
		action.click(btn_ok());
		return new ParentsListPage(driver);
	
	}
	
	public ParentsListPage photoAlbumsDeleteSubmit(int i,int j) {
		action.click(btn_correct());
		action.click(btn_camera());
		action.click(btn_PhotoAlbum());
		for(int m=j;m<=i+j;m++) {
			action.click(selectPhoto(m));
		}
		action.click(btn_apply());
		action.click(btn_next());
		for(int m=j;m<i+j;m++) {
			action.click(btn_deleteSome());
		}
		action.click(btn_submit());
		action.click(btn_ok());
		return new ParentsListPage(driver);
	
	}
	
	public ParentsListPage photoAlbumsDeleteAllSubmit(int i,int j) {
		action.click(btn_correct());
		action.click(btn_camera());
		action.click(btn_PhotoAlbum());
		for(int m=j;m<=i+j;m++) {
			action.click(selectPhoto(m));
		}
		action.click(btn_apply());
		action.click(btn_next());
		for(int m=j;m<i+j;m++) {
			action.click(btn_deleteSome());
		}
		action.click(btn_delete());
		action.click(btn_submit());
		action.click(btn_ok());
		return new ParentsListPage(driver);
	
	}
	
	public ParentsListPage viewMessage(int i) {
		action.click(btn_correct());
		action.click(btn_ring());
		action.click(btn_ringi(i));
		
		return new ParentsListPage(driver);
	
	}
	
	public ParentsListPage SomeviewMessage(int i,int j) {
		action.click(btn_correct());
		action.click(btn_ring());
		for(int m=i;m<i+j;m++) {
			action.click(btn_ringi(m));
			action.click(btn_return());
		}
		return new ParentsListPage(driver);
	
	}
	public ParentsListPage ReplyMessage(int i,String message) {
		action.click(btn_correct());
		action.click(btn_ring());
		action.click(btn_ringi(i));
		action.type(edit_replyMessage(),message);
		action.click(btn_send());
		
		return new ParentsListPage(driver);
	
	}
	
	public ParentsListPage SomereplyMessage(int i,int j,String message) {
		action.click(btn_correct());
		action.click(btn_ring());
		for(int m=i;m<i+j;m++) {
			action.click(btn_ringi(m));
			action.type(edit_replyMessage(),message);
			action.click(btn_send());
			action.click(btn_return());
		}
		return new ParentsListPage(driver);
	
	}
	
	public ParentsListPage TopMessage(int i) {
		action.click(btn_correct());
		action.click(btn_ring());
		action.longPress(btn_ringi(i));
		action.click(btn_topMessage());
		
		return new ParentsListPage(driver);
	
	}
	
	public ParentsListPage SomeTopMessage(int i) {
		action.click(btn_correct());
		action.click(btn_ring());
		for(int m=0;m<i;m++) {
			action.longPress(btn_ringi(2));
			action.click(btn_topMessage());
		}
		
		return new ParentsListPage(driver);
	
	}
	
	public ParentsListPage CancelTopMessage(int i) {
		action.click(btn_correct());
		action.click(btn_ring());
		for(int m=0;m<i;m++) {
			action.longPress(btn_ringi(1));
			action.click(btn_topMessage());
		}
		
		return new ParentsListPage(driver);
	
	}
	
	public ParentsListPage DeleteMessage(int i) {
		action.click(btn_correct());
		action.click(btn_ring());
		action.longPress(btn_ringi(i));
		action.click(btn_deleteMessage());
		
		return new ParentsListPage(driver);
	
	}
	
	public ParentsListPage DeleteSomeMessage(int i,int j) {
		action.click(btn_correct());
		action.click(btn_ring());
		for(int m=0;m<j;m++) {
		action.longPress(btn_ringi(i));
		action.click(btn_deleteMessage());
		}
		return new ParentsListPage(driver);
	
	}
}
