package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.BaseAction;

public class MinePage {
	AndroidDriver<AndroidElement> driver;
	BaseAction action;
	public MinePage(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
		this.action = new BaseAction (driver);
	}
	
	//我的钱包
	public AndroidElement myWallet() {
		return driver.findElementById("com.example.homeworkcorrectteacher:id/mywallet");
	}
	
	//进行中
	public AndroidElement conduct() {
		return driver.findElementById("com.example.homeworkcorrectteacher:id/ll_doing");
	}
	
	//已完成
	public AndroidElement completed() {
		return driver.findElementById("com.example.homeworkcorrectteacher:id/finished_liner");
	}
	//继续批改按钮
	public AndroidElement correction() {
		return driver.findElementById("com.example.homeworkcorrectteacher:id/continuebtn");
	}
	//提交批改按钮
	public AndroidElement submit() {
		return driver.findElementById("com.example.homeworkcorrectteacher:id/submit");
	}

	//查看批改详情
	public AndroidElement detail() {
		return driver.findElementById("com.example.homeworkcorrectteacher:id/detail");
	}
	
	//联系我们
	public AndroidElement contactus() {
		return driver.findElementById("com.example.homeworkcorrectteacher:id/contactUs");
	}
	
	//添加官微
	public AndroidElement wechat() {
		return driver.findElementById("com.example.homeworkcorrectteacher:id/wechat");
	}
	
	//设置
	public AndroidElement setting() {
		return driver.findElementById("com.example.homeworkcorrectteacher:id/setting_relative");
	}
	//注销账号
	public AndroidElement logoff() {
		return driver.findElementById("com.example.homeworkcorrectteacher:id/logoff");
	}
	
	//教师评语
	public AndroidElement correct() {
		return driver.findElementById("com.example.homeworkcorrectteacher:id/correct_self_text");
	}
	
	//ok按钮
	public AndroidElement but_ok() {
		return driver.findElementById("com.example.homeworkcorrectteacher:id/dialog_button");
	}
	
	//我的
	public AndroidElement mine() {
		return driver.findElementById("com.example.homeworkcorrectteacher:id/mine");
	}
}
