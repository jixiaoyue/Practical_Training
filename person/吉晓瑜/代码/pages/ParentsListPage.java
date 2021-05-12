//NotesListPage类
package pages;

import java.util.List;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.BaseAction;

public class ParentsListPage {
	AndroidDriver<AndroidElement> driver;
	BaseAction action;

//	构造方法
	public ParentsListPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		this.action = new BaseAction(driver);

	}

//	页面对象
	public AndroidElement parent() {
		return driver.findElementById("com.example.homeworkcorrect:id/parent_circle_text");
	}
	
	public AndroidElement parent_add() {
		return driver.findElementById( "com.example.homeworkcorrect:id/publish");
	}
	public AndroidElement show_first_photo() {
		return driver.findElementById("com.example.homeworkcorrect:id/send_img");
	}

	
//	public 
//	获取第一个动态
	public MobileElement get_dy_first() {
		AndroidElement listView = driver.findElementById("com.example.homeworkcorrect:id/listview");
		List<MobileElement> list_view = listView.findElementsByClassName("android.widget.RelativeLayout");
		int count = list_view.size();
		if (count > 0) {
			return list_view.get(0);
		}
		return null;

	}
//	获取第一个动态图片
	public MobileElement get_dy_first_photo() {
		AndroidElement listView = driver.findElementById("com.example.homeworkcorrect:id/send_img_list");
		List<MobileElement> list_view = listView.findElementsByClassName("android.widget.ImageView");
		int count = list_view.size();
		if (count > 0) {
			return list_view.get(0);
		}
		return null;
	}
	public int get_item_num() {
		AndroidElement listView = driver.findElementById("com.example.homeworkcorrect:id/listview");
		List<MobileElement> list_view = listView.findElementsByClassName("android.widget.RelativeLayout");
		int count = list_view.size();
		
		return count;

	}
//	页面方法
	public ParentsEditor show_list() {
		action.click(parent());
		return new ParentsEditor(driver);
	}
	public void show_first_dy() throws InterruptedException {
		action.click(get_dy_first());
		action.click(show_first_photo());
		Thread.sleep(1000);
		driver.navigate().back();
	}
	public void show_dy_first_photo() {
		action.click(get_dy_first_photo());
	}
	public void photo_check() throws InterruptedException {
		action.SwipeLeft();
		Thread.sleep(1000);
		action.SwipeRight();
		
	}
//	add->editor
	public ParentsEditor add() {
		action.click(parent());
		action.click(parent_add());
		int[][] keyboardArr = { { 521, 134 }, { 720, 1280 } };
		action.clickElement_OverScreen(keyboardArr);
		return new ParentsEditor(driver);
	}



}
