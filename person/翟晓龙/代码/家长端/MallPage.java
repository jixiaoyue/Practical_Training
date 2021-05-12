package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.BaseAction;

public class MallPage {
	AndroidDriver<AndroidElement> driver;
	BaseAction action;

//	通过构造方法对于driver初始化；
	public MallPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		this.action = new BaseAction(driver);
		;
	}

	public BaseAction action() {
		return action;
	}

	public AndroidElement mall() {
		return driver.findElementById("com.example.homeworkcorrect:id/shop_img");
	}
	//商城搜索框
	public AndroidElement search() {
		return driver.findElementById("com.example.homeworkcorrect:id/search_tv_search");
	}
	//商城搜索按钮
	public AndroidElement btn_search() {
		return driver.findElementByClassName("android.widget.TextView");
	}
	//商城商品
	public AndroidElement commodity() {
		return driver.findElementById("com.example.homeworkcorrect:id/commodity_img");
	}

	public AndroidElement institutions() {
		return driver.findElementByClassName("android.widget.Button");
	}

	// 加入购物车按钮元素
	public AndroidElement shopping_Cart() {
		return driver.findElementsByClassName("android.widget.Button").get(0);
	}

	// 立即购买按钮元素
	public AndroidElement purchase() {
		return driver.findElementsByClassName("android.widget.Button").get(1);
	}
	//设置
	public AndroidElement setting() {
		return driver.findElementById("com.example.homeworkcorrect:id/setting_relative");
	}
	//我的
	public AndroidElement mine() {
		return driver.findElementById("com.example.homeworkcorrect:id/mine_img");
	}
	//注销账号
	public AndroidElement logoff() {
		return driver.findElementById("com.example.homeworkcorrect:id/logoff");
	}
}
